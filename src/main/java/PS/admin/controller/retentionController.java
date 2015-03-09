package PS.admin.controller;

public class retentionController extends BaseController{

	@Override
	protected void templateMethod(Integer serverId) {
		if (serverId < 0) {
			return;
		}
		String page = getPara("page");
		setAttr("page", page);
	}
}
