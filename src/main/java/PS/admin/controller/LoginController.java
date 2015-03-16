package PS.admin.controller;

import static PS.admin.common.LoginInfo.DUPLICATE_ACCOUNT;
import static PS.admin.common.LoginInfo.ERROR_PSW;
import static PS.admin.common.LoginInfo.NO_ADMINISTRATOR;

import java.util.List;

import PS.admin.model.ServerInfo;
import PS.admin.model.UserInfo;
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
		} else if (result == DUPLICATE_ACCOUNT.number()) {
			setAttr("lgMsg", "账号重复!");
			keepPara("username", "userpassworld");
			render("/index/login.jsp");
			return;
		}
		setAttr("user",UserInfo.getUsers().get(username));
		LoginService.service.getServerInfo();
		List<ServerInfo> ls = ServerInfo.getServerInfoList();
		if (ls.size() == 0) {
			setAttr("serslmsg", "获取服务器列表服务未启动,请启动后重新登录!");
		}
		setAttr("serverList", ls);
		render("/base/basePage.jsp");
	}

	/**
	 * 注销
	 */
	public void logout() {
		render("login.jsp");
	}

	@Override
	protected void templateMethod(Integer serverId) {}
}