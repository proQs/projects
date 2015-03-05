package PS.admin.controller;

import static PS.admin.common.LoginInfo.ERROR_PSW;
import static PS.admin.common.LoginInfo.NO_ADMINISTRATOR;
import PS.admin.model.ServerInfo;
import PS.admin.service.LoginService;
import PS.admin.validator.LoginValidator;

import com.jfinal.aop.Before;

public class LoginController extends BaseController{

	public void index() {
		render("login.jsp");
	}
	
	/**
	 * 登陆验证
	 */
	@Before(LoginValidator.class)
	public void vali() {
		String username = getPara("username");
	    String password = getPara("userpassworld");
		int result = LoginService.service.login(username, password);
		if (result == NO_ADMINISTRATOR.number()) {
			setAttr("lgMsg", "账号不存在!");
			keepPara("username", "userpassworld");
			render("/index/login.jsp");
			return;
		} else if (result == ERROR_PSW.number()) {
			setAttr("lgMsg", "密码不正确!");
			keepPara("username", "userpassworld");
			render("/index/login.jsp");
			return;
		}
		keepPara("username");
		setAttr("permissions", "1");
		setAttr("serverList", ServerInfo.getServerInfoList());
		render("/base/basePage.jsp");
	}

	/**
	 * 注销
	 */
	public void logout() {
		redirect("/index/login.jsp");
	}
}