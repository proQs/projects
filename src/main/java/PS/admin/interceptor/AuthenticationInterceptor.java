package PS.admin.interceptor;

import PS.admin.controller.BaseController;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class AuthenticationInterceptor implements Interceptor{

	public void intercept(ActionInvocation ai) {
		BaseController contro = (BaseController) ai.getController();
		try {
			ai.invoke();
		} catch (Exception e) {
			e.printStackTrace();
			toInfoJsp(contro);
		}
	}

	private void toInfoJsp(BaseController contro) {
		contro.setAttr("msg", "操作有误");
		contro.render("/base/msg.jsp");
	}
}
