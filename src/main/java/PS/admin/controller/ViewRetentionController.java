package PS.admin.controller;

import java.util.List;

import PS.admin.model.retentionInfo;
import PS.admin.service.ViewRetentionService;

public class ViewRetentionController extends BaseFunctionController{

	public void index() {
		super.baseIndex();
	}
	
	@Override
	protected boolean templateFunctionMethod(final Integer serverId) {
		final String startDate = getPara("startDate");
		List<retentionInfo> rif = ViewRetentionService.service.viewRetention(startDate, serverId);
		if (rif == null) {
			return false;
		}
	    setAttr("startDatere", startDate);
		setAttr("viewRetention", true);
		setAttr("retentionlist", rif);
		return true;
	}

}
