package PS.admin.controller;

import java.util.Map;

import PS.admin.model.ServerDBInfo;
import PS.admin.model.ServerInfo;

public abstract class BaseFunctionController extends BaseController{

	@Override
	protected final void templateMethod(Integer serverId) {
		Map<Integer, ServerDBInfo> sdb = ServerInfo.getServerDBInfo();
		if (serverId < 0 || !sdb.containsKey(serverId)) {
			setAttr("serslmsg", "服务器不存在或未启动!");
			return;
		}
		templateFunctionMethod(serverId);
		String page = getPara("page");
		setAttr("page", page);
	}

	protected abstract void templateFunctionMethod(Integer serverId);
}
