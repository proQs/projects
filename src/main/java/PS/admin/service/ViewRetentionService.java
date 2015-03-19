package PS.admin.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import PS.admin.common.Config;
import PS.admin.common.RetentionType;
import PS.admin.model.ServerInfo;
import PS.admin.model.retentionInfo;
import PS.admin.tools.CommonUtil;
import PS.admin.tools.ToolDateTime;

import com.jfinal.plugin.activerecord.Db;

public class ViewRetentionService extends BaseService {

	public static final ViewRetentionService service = new ViewRetentionService();

	public List<retentionInfo> viewRetention(final String startDate, final int serverId) {
		Callable<List<retentionInfo>> call = new Callable<List<retentionInfo>>() {
			public List<retentionInfo> call() throws Exception {
				return ViewRetentionService.service.getViewRetention(startDate, serverId);
			}
		};
		return CommonUtil.callSingleThread(call);
	}

	private List<retentionInfo> getViewRetention(String startDate, int serverId) {
		Date start = ToolDateTime.parse(startDate, ToolDateTime.pattern_ymd_hms);
		ServerInfo sif = ServerInfo.getServerInfo(serverId);
		String dbName = sif.getLogDBName();
		String gameDbName = sif.getGameDBName();
		List<BigInteger> createMembers = getCreateUsers(start, dbName);
		long[] lastLogin = getMembersLastlogin(createMembers, gameDbName);
		log.info(Arrays.toString(lastLogin));
		int allCreateNum = createMembers.size();
		int allloginNum = getLoginNum(start, dbName);
		int oneDay_retentionNum = 0;
		int threeDay_retentionNum = 0;
		int sevenDay_retentionNum = 0;
		for (int i = 0; i < allCreateNum; i++) {
			long days = lastLogin[i] - start.getTime();
			if (days > Config.SEVEN_DAY) {
				oneDay_retentionNum ++;
				threeDay_retentionNum ++;
				sevenDay_retentionNum ++;
			} else if (days > Config.THREE_DAY) {
				oneDay_retentionNum ++;
				threeDay_retentionNum ++;
			} else if (days > Config.ONE_DAY) {
				oneDay_retentionNum ++;
			}
		}
		List<retentionInfo> rif = new ArrayList<retentionInfo>();
		if (allCreateNum > 0) {
			rif.add(new retentionInfo(allCreateNum, allloginNum, RetentionType.ONEDAY.number(), oneDay_retentionNum,
					(int) (new BigDecimal(oneDay_retentionNum).divide(new BigDecimal(allCreateNum), 4, RoundingMode.HALF_UP).floatValue() * 10000)));
			rif.add(new retentionInfo(allCreateNum, allloginNum, RetentionType.THREEDAY.number(), threeDay_retentionNum,
					(int) (new BigDecimal(threeDay_retentionNum).divide(new BigDecimal(allCreateNum), 4, RoundingMode.HALF_UP).floatValue() * 10000)));
			rif.add(new retentionInfo(allCreateNum, allloginNum, RetentionType.SEVEBDAY.number(), sevenDay_retentionNum,
					(int) (new BigDecimal(sevenDay_retentionNum).divide(new BigDecimal(allCreateNum), 4, RoundingMode.HALF_UP).floatValue() * 10000)));
		} else {
			rif.add(new retentionInfo(allCreateNum, allloginNum, RetentionType.ONEDAY.number(), oneDay_retentionNum, 0));
			rif.add(new retentionInfo(allCreateNum, allloginNum, RetentionType.THREEDAY.number(), threeDay_retentionNum, 0));
			rif.add(new retentionInfo(allCreateNum, allloginNum, RetentionType.SEVEBDAY.number(), sevenDay_retentionNum, 0));
		}
		return rif;
	}

	private long[] getMembersLastlogin(List<BigInteger> createMembers, String gameDbName) {
		long[] mll = new long[createMembers.size()];
		int count = 0;
		for (BigInteger uid : createMembers) {
			String name = "usersinfo";
			String sql = "select timestamp from " + name + " where uid = ?";
			log.info(sql);
			mll[count++] = ((java.math.BigInteger)Db.use(gameDbName).queryColumn(sql, uid)).longValue() * 1000;
		}
		return mll;
	}

	private List<BigInteger> getCreateUsers(Date start, String dbName) {
		String name = CommonUtil.getLogTable(start);
		String sql = "select uid from " + name + " where type = " + Config.Log_CreateUser;
		log.info(sql);
		List<BigInteger> re = Db.use(dbName).query(sql);
		return re;
	}

	private int getLoginNum(Date start, String dbName) {
		String name = CommonUtil.getLogTable(start);
		String sql = "select * from " + name + " where type = " + Config.Log_Login + " group by uid";
		log.info(sql);
		List<?> num = Db.use(dbName).query(sql);
		return num.size();
	}
}
