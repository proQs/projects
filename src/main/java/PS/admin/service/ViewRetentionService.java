package PS.admin.service;

import java.util.Date;
import java.util.List;

import PS.admin.common.Config;
import PS.admin.model.ServerInfo;
import PS.admin.model.retentionInfo;
import PS.admin.tools.CommonUtil;
import PS.admin.tools.ToolDateTime;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

public class ViewRetentionService extends BaseService {

	public static final ViewRetentionService service = new ViewRetentionService();

	public retentionInfo viewRetention(String startDate, String endDate, int serverId) {
		Date start = ToolDateTime.parse(startDate, ToolDateTime.pattern_ymd_hms);
		Date end = ToolDateTime.parse(endDate, ToolDateTime.pattern_ymd_hms);
		int times = ToolDateTime.getDateDaySpace(start, end);
		if (times < 2) {
			return null;
		}
		ServerInfo sif = ServerInfo.getServerInfo(serverId);
		String dbName = sif.getName();
		int createMembers = getCreateUsers(start, dbName);
		for (int i = times; i > 0; i--) {
			
		}
		return null;
	}

	private int getCreateUsers(Date start, String dbName) {
		String name = CommonUtil.getLogTable(start);
		String sql = "select uid from " + name + " where type = " + Config.Log_CreateUser;
		log.info(sql);
		List<Record> re = Db.use(dbName).find(sql);
		log.info(re.size());
		return re.size();
	}

}
