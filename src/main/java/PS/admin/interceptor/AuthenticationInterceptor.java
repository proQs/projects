package PS.admin.interceptor;

import org.apache.log4j.Logger;

import PS.admin.controller.BaseController;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class AuthenticationInterceptor implements Interceptor{

	private static Logger log = Logger.getLogger(AuthenticationInterceptor.class);
	
	public void intercept(ActionInvocation ai) {
		BaseController contro = (BaseController) ai.getController();
		try {
			ai.invoke();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("exception", e);
			toInfoJsp(contro);
		}
	}

	private void toInfoJsp(BaseController contro) {
		contro.setAttr("msg", "操作有误");
		contro.render("/base/msg.jsp");
	}
}
