package PS.admin.controller;

import PS.admin.service.ViewRetentionService;

public class ViewRetentionController extends BaseFunctionController{

	public void index() {
		super.baseIndex();
	}
	
	@Override
	protected void templateFunctionMethod(Integer serverId) {
		String startDate = getPara("startDate");
	    String endDate = getPara("endDate");
	    ViewRetentionService.service.viewRetention(startDate, endDate, serverId);
		setAttr("viewRetention", true);
	}

}
