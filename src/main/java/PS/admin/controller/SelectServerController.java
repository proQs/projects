package PS.admin.controller;

import PS.admin.service.SelectSvService;
import PS.admin.tools.CommonUtil;

public class SelectServerController extends BaseController{

	private static final Object obj = new Object();
	
	public void index() {
		super.baseIndex();
	}
	
	@Override
	protected void templateMethod(Integer serverId) {
		if (serverId > 0) {
			SelectSvService.service.getDBInfo(serverId);
			synchronized (obj) {
				CommonUtil.connectLogDB(serverId);
			}
		}
	}
}
