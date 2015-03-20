package PS.admin.controller;

import PS.admin.common.SplitPage;
import PS.admin.service.ViewMultiLogService;

import com.jfinal.plugin.activerecord.Record;

public class viewMultiLogController extends BaseFunctionController{

	public void index() {
		super.baseIndex();
	}
	
	@Override
	protected boolean templateFunctionMethod(final Integer serverId) {
		final String startDate = getPara("startDate");
		final String endDate = getPara("endDate");
		Integer[] logTypes = getParaValuesToInt("logType");
		SplitPage<Record> sp = getSessionAttr("multiSplitPage");
		if (getPara("currentPage") == null || sp == null) {
			sp = new SplitPage<Record>();
//			defaultOrder("logType", "asc");
			if (!ViewMultiLogService.service.viewMultiLog(startDate, endDate, serverId , logTypes, sp)) {
				return false;
			}
			setSessionAttr("multiSplitPage", sp);
		}
		sp.setPageNumber(getParaToInt("currentPage", 1));
		sp.compute();
	    setAttr("startDatere", startDate);
	    setAttr("endDatere", endDate);
		setAttr("multiLoglist", sp.getPageList());
		setAttr("splitPage", sp);
		return true;
	}

}
