package PS.admin.controller;

import java.util.concurrent.ConcurrentHashMap;

import PS.admin.model.ServerInfo;
import PS.admin.service.SelectSvService;
import PS.admin.tools.CommonUtil;

public class SelectServerController extends BaseController{

	private static final Object obj = new Object();
	private static final ConcurrentHashMap<Integer, Boolean> serMap = new ConcurrentHashMap<Integer, Boolean>();
	
	public void index() {
		super.baseIndex();
	}
	
	@Override
	protected void templateMethod(Integer serverId) {
		if (serverId > 0) {
			if (!SelectSvService.service.getDBInfo(serverId)) {
				return;
			}
			log.info(serMap);
			if (serMap.putIfAbsent(serverId, false) != null) {
				return;
			}
			ServerInfo sif = ServerInfo.getServerInfo(serverId);
			String logdb = sif.getLogDBName();
			String gamedb = sif.getGameDBName();
			synchronized (obj) {
				if (serMap.get(serverId)) {
					return;
				}
				CommonUtil.connectLogDB(logdb, serverId);
				CommonUtil.connectGameDB(gamedb, serverId);
				serMap.put(serverId, true);
			}
		}
	}
}
