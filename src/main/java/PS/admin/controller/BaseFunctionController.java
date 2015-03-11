package PS.admin.controller;

public abstract class BaseFunctionController extends BaseController{

	@Override
	protected final void templateMethod(Integer serverId) {
		if (serverId < 0) {
			return;
		}
		templateFunctionMethod(serverId);
		String page = getPara("page");
		setAttr("page", page);
	}

	protected abstract void templateFunctionMethod(Integer serverId);
}
