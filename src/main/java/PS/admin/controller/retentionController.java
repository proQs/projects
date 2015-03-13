package PS.admin.controller;

public class retentionController extends BaseFunctionController{

	public void index() {
		super.baseIndex();
	}

	@Override
	protected boolean templateFunctionMethod(Integer serverId) {
		return true;
	}
}
