package PS.admin.controller;

import java.util.List;

import PS.admin.model.retentionInfo;
import PS.admin.service.ViewRetentionService;

public class ViewRetentionController extends BaseFunctionController{

	public void index() {
		super.baseIndex();
	}
	
	@Override
	protected void templateFunctionMethod(Integer serverId) {
		String startDate = getPara("startDate");
	    List<retentionInfo> rif = ViewRetentionService.service.viewRetention(startDate, serverId);
	    setAttr("startDatere", startDate);
		setAttr("viewRetention", true);
		setAttr("retentionlist", rif);
	}

}
