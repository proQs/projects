package PS.admin.service;

import java.util.List;
import java.util.Map;

import PS.admin.common.LoginInfo;
import PS.admin.model.Adminaccount;
import PS.admin.model.ServerInfo;
import PS.admin.model.UserInfo;
import PS.admin.tools.CommonUtil;

public class LoginService extends BaseService{

	public static final LoginService service = new LoginService();
	
	public int login(String username, String password) {
		List<Adminaccount> ad = null;
		Map<String, UserInfo> users = UserInfo.getUsers();
		if (users.containsKey(username)) {
			 if (password.equals(users.get(username).getPsw())) {
				 return LoginInfo.OK_LOGIN.number();
			}
			return LoginInfo.ERROR_PSW.number();
		} else {
			ad = Adminaccount.me.find("select * from adminaccount where name = ?", username);
		}
		if (ad.size() < 1) {
			return LoginInfo.NO_ADMINISTRATOR.number();
		}
		if (ad.size() >= 2) {
			return LoginInfo.DUPLICATE_ACCOUNT.number();
		}
		if (ad.get(0).getStr("password").equals(password)) {
			UserInfo.addUsers(username, new UserInfo(username, password, ad.get(0).getInt("permission")));
			return LoginInfo.OK_LOGIN.number();
		}
		return LoginInfo.ERROR_PSW.number();
	}

	public void getServerInfo() {
		List<ServerInfo> ls = ServerInfo.getServerInfoList();
		if (ls.size() != 0) {
			return;
		}
		synchronized (service) {
			if (ls.size() != 0) {
				return;
			}
			CommonUtil.getServerInfo(this.getClass().getClassLoader());
		}
	}
	
	
}
