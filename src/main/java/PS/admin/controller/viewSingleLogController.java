package PS.admin.controller;

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
		SplitPage sp = getSplitPage();
		sp.setPageNumber(getParaToInt("currentPage", 1));
		defaultOrder("type", "asc");
		if (!ViewSingleLogService.service.viewSingleLog(uid, startDate, endDate, serverId , splitPage)) {
			return false;
		}
		setAttr("userUID", uid);
	    setAttr("startDatere", startDate);
	    setAttr("endDatere", endDate);
		setAttr("viewSingleLog", true);
		setAttr("singleLoglist", splitPage.getList().get(0));
		setAttr("splitPage", splitPage);
		return true;
	}

}
