package PS.admin.service;

import java.util.Date;
import java.util.List;

import PS.admin.common.Config;
import PS.admin.common.SplitPage;
import PS.admin.model.ServerInfo;
import PS.admin.tools.CommonUtil;
import PS.admin.tools.ToolDateTime;

public class ViewSingleLogService extends BaseService {

	public static final ViewSingleLogService service = new ViewSingleLogService();

	public boolean viewSingleLog(final long uid, String startDate, String endDate, Integer serverId, final SplitPage splitPage) {
		Date start = ToolDateTime.parse(startDate, ToolDateTime.pattern_ymd_hms);
		Date end = ToolDateTime.parse(endDate, ToolDateTime.pattern_ymd_hms);
		final List<Date> lsd = ToolDateTime.getDateSplit(start, end, Config.ONE_DAY);
		log.info(lsd.toString());
		ServerInfo sif = ServerInfo.getServerInfo(serverId);
		final String dbName = sif.getLogDBName();
		Runnable run = new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				List<?> ls = splitPage.getList();
				ls = null;
				for (Date date : lsd) {
					list(splitPage, dbName, uid, date);
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
	 */
	private void list(SplitPage splitPage, String dbName, Object paramValue, Date start){
		String name = CommonUtil.getLogTable(start);
		String sql = " select type,log_time,msg ";
		String sqlExcept = "from " + name + " where uid = ?";
		splitPageBase(dbName, splitPage, sql, sqlExcept, paramValue);
	}
	
}
