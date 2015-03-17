package PS.admin.controller;

public class singleLogController extends BaseFunctionController{

	public void index() {
		super.baseIndex();
	}

	@Override
	protected boolean templateFunctionMethod(Integer serverId) {
		return true;
	}
}
