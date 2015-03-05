package PS.admin.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * LoginValidator.
 */
public class LoginValidator extends Validator {
	
	protected void validate(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/PSadminlogin/vali")){
			validateRequiredString("username", "nameMsg", "请输入账号!");
			validateRequiredString("userpassworld", "pswMsg", "请输入密码!");
		}
	}
	
	protected void handleError(Controller controller) {
		String actionKey = getActionKey();
		if (actionKey.equals("/PSadminlogin/vali")){
			controller.keepPara("username", "userpassworld");
			controller.render("/index/login.jsp");
		}
	}
}
