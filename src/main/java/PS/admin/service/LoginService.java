package PS.admin.service;

import java.util.List;

import PS.admin.common.LoginInfo;
import PS.admin.model.Adminaccount;

public class LoginService {

	public static final LoginService service = new LoginService();
	
	private LoginService() {}

	public int login(String username, String password) {
		List<Adminaccount> ad = Adminaccount.me.find("select * from adminaccount where name = ?", username);
		if (ad.size() < 1) {
			return LoginInfo.NO_ADMINISTRATOR.number();
		}
		if (ad.size() > 2) {
			for (Adminaccount adminaccount : ad) {
				if (adminaccount.getStr("password").equals(password)) {
					return LoginInfo.OK_LOGIN.number();
				} else {
					return LoginInfo.ERROR_PSW.number();
				}
			}
		}
		if (ad.get(0).getStr("password").equals(password)) {
			return LoginInfo.OK_LOGIN.number();
		}
		return LoginInfo.ERROR_PSW.number();
	}
	
	
}
