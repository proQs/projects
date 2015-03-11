package PS.admin.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import PS.admin.common.Config;
import PS.admin.common.RetentionType;
import PS.admin.model.ServerInfo;
import PS.admin.model.retentionInfo;
import PS.admin.tools.CommonUtil;
import PS.admin.tools.ToolDateTime;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class ViewRetentionService extends BaseService {

	public static final ViewRetentionService service = new ViewRetentionService();

	public List<retentionInfo> viewRetention(String startDate, int serverId) {
		Date start = ToolDateTime.parse(startDate, ToolDateTime.pattern_ymd_hms);
		ServerInfo sif = ServerInfo.getServerInfo(serverId);
		String dbName = sif.getLogDBName();
		String gameDbName = sif.getGameDBName();
		HashMap<Long, Long> createMembers = getCreateUsers(start, dbName);
		long[] lastLogin = getMembersLastlogin(createMembers.keySet(), gameDbName);
		Long[] createLogin = createMembers.values().toArray(new Long[0]);
		int allCreateNum = createLogin.length;
		int oneDay_retentionNum = 0;
		int threeDay_retentionNum = 0;
		int sevenDay_retentionNum = 0;
		for (int i = 0; i < allCreateNum; i++) {
			log.debug("lastLogin[i]" + lastLogin[i]);
			log.debug("createLogin[i]" + createLogin[i]);
			long days = lastLogin[i] - createLogin[i];
			if (days > Config.ONE_DAY) {
				oneDay_retentionNum ++;
			} else if (days > Config.THREE_DAY) {
				oneDay_retentionNum ++;
				threeDay_retentionNum ++;
			} else if (days > Config.SEVEN_DAY) {
				oneDay_retentionNum ++;
				threeDay_retentionNum ++;
				sevenDay_retentionNum ++;
			}
		}
		List<retentionInfo> rif = new ArrayList<retentionInfo>();
		if (oneDay_retentionNum > 0) {
			rif.add(new retentionInfo(startDate, RetentionType.ONEDAY.type(), allCreateNum, oneDay_retentionNum,
					new BigDecimal(oneDay_retentionNum).divide(new BigDecimal(allCreateNum), 4, RoundingMode.HALF_UP).floatValue()));
		}
		if (threeDay_retentionNum > 0) {
			rif.add(new retentionInfo(startDate, RetentionType.THREEDAY.type(), allCreateNum, threeDay_retentionNum,
					new BigDecimal(threeDay_retentionNum).divide(new BigDecimal(allCreateNum), 4, RoundingMode.HALF_UP).floatValue()));
		}
		if (sevenDay_retentionNum > 0) {
			rif.add(new retentionInfo(startDate, RetentionType.SEVEBDAY.type(), allCreateNum, sevenDay_retentionNum,
					new BigDecimal(sevenDay_retentionNum).divide(new BigDecimal(allCreateNum), 4, RoundingMode.HALF_UP).floatValue()));
		}
		if (rif.size() == 0) {
			return null;
		}
		return rif;
	}

	private long[] getMembersLastlogin(Set<Long> keySet, String gameDbName) {
		long[] mll = new long[keySet.size()];
		int count = 0;
		for (long uid : keySet) {
			String name = "usersinfo";
			String sql = "select timestamp from " + name + " where uid = ?";
			log.info(sql);
			mll[count++] = ((java.math.BigInteger)Db.use(gameDbName).queryColumn(sql, uid)).longValue();
		}
		return mll;
	}

	private HashMap<Long, Long> getCreateUsers(Date start, String dbName) {
		String name = CommonUtil.getLogTable(start);
//		String sql = "select uid,log_time from " + name + " where type = " + Config.Log_Login;
		String sql = "select uid,log_time from " + name + " where type = " + Config.Log_CreateUser;
		log.info(sql);
		List<Record> re = Db.use(dbName).find(sql);
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		for (Record record : re) {
			map.put(record.getBigInteger("uid").longValue(), record.getTimestamp("log_time").getTime()/1000);
		}
		log.info(map.size());
		return map;
	}

}
