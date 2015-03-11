package PS.admin.controller;

import PS.admin.model.ServerInfo;
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
			ServerInfo sif = ServerInfo.getServerInfo(serverId);
			String logdb = sif.getLogDBName();
			String gamedb = sif.getGameDBName();
			synchronized (obj) {
				CommonUtil.connectLogDB(logdb, serverId);
				CommonUtil.connectGameDB(gamedb, serverId);
			}
		}
	}
}
