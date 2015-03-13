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
		if (!templateFunctionMethod(serverId)) {
			setAttr("serslmsg", "连接数据库失败,请确认操作!");
			return;
		}
		String page = getPara("page");
		setAttr("page", page);
	}

	protected abstract boolean templateFunctionMethod(Integer serverId);
}
