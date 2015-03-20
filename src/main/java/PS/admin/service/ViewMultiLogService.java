package PS.admin.service;

import java.util.Date;
import java.util.List;

import PS.admin.common.Config;
import PS.admin.common.SplitPage;
import PS.admin.model.ServerInfo;
import PS.admin.tools.CommonUtil;
import PS.admin.tools.ToolDateTime;

import com.jfinal.plugin.activerecord.Record;

public class ViewMultiLogService extends BaseService {

	public static final ViewMultiLogService service = new ViewMultiLogService();

	public boolean viewMultiLog(String startDate, String endDate, Integer serverId, final Integer[] logTypes, final SplitPage<Record> splitPage) {
		Date start = ToolDateTime.parse(startDate, ToolDateTime.pattern_ymd_hms);
		Date end = ToolDateTime.parse(endDate, ToolDateTime.pattern_ymd_hms);
		final List<Date> lsd = ToolDateTime.getDateSplit(start, end, Config.ONE_DAY);
		ServerInfo sif = ServerInfo.getServerInfo(serverId);
		final String dbName = sif.getLogDBName();
		for (int i = 0; i < logTypes.length; i++) {
			logTypes[i] += Config.Log_UserLevelUp;
		}
		Runnable run = new Runnable() {
			public void run() {
				for (Date date : lsd) {
					list(splitPage, dbName, date, logTypes);
				}
			}
		};
		return CommonUtil.runSingleThread(run);
	}
	
	/**
	 * 分页
	 * @param splitPage
	 * @param paramValue 
	 * @param dbName 
	 * @param start 
	 * @param logTypes 
	 */
	private void list(SplitPage<Record> splitPage, String dbName, Date start, Integer[] logTypes){
		String name = CommonUtil.getLogTable(start);
		String sql = " select uid,type,log_time,msg ";
		StringBuilder sqlExcept = new StringBuilder("from ");
		sqlExcept.append(name);
		sqlExcept.append(" where type in (");
		for (int i = 0; i < logTypes.length; i++) {
			sqlExcept.append("?");
			if (i != logTypes.length - 1) {
				sqlExcept.append(", ");
			}
		}
		sqlExcept.append(")");
		splitPageBase(dbName, splitPage, sql, sqlExcept.toString(), logTypes);
	}
}
