package PS.admin.controller;

import com.jfinal.plugin.activerecord.Record;

import PS.admin.common.SplitPage;
import PS.admin.service.ViewSingleLogService;

public class viewSingleLogController extends BaseFunctionController{

	public void index() {
		super.baseIndex();
	}
	
	@Override
	protected boolean templateFunctionMethod(final Integer serverId) {
		final long uid = getParaToLong("userUID");
		final String startDate = getPara("startDate");
		final String endDate = getPara("endDate");
		SplitPage<Record> sp = getSessionAttr("singleSplitPage");
		if (getPara("currentPage") == null || getSessionAttr("singleSplitPage") == null) {
			sp = new SplitPage<Record>();
			if (!ViewSingleLogService.service.viewSingleLog(uid, startDate, endDate, serverId , sp)) {
				return false;
			}
			setSessionAttr("singleSplitPage", sp);
		}
		sp.setPageNumber(getParaToInt("currentPage", 1));
		sp.compute();
		setAttr("userUID", uid);
	    setAttr("startDatere", startDate);
	    setAttr("endDatere", endDate);
		setAttr("viewSingleLog", true);
		setAttr("singleLoglist", sp.getPageList());
		setAttr("splitPage", sp);
		return true;
	}

}
