package PS.admin.controller;

public class multiLogController extends BaseFunctionController{

	public void index() {
		super.baseIndex();
	}

	@Override
	protected boolean templateFunctionMethod(Integer serverId) {
		return true;
	}
}
