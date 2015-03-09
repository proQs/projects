package PS.admin.controller;

import PS.admin.service.SelectSvService;

public class SelectServerController extends BaseController{

	@Override
	protected void templateMethod(Integer serverId) {
		if (serverId > 0) {
			SelectSvService.service.getDBInfo(serverId);
		}
	}
}
