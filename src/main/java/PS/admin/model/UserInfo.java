package PS.admin.model;

import java.util.concurrent.ConcurrentHashMap;

public class UserInfo {

	private final String name;
	private final String psw;
	private final int permissions;
	private static final ConcurrentHashMap<String, UserInfo> users = new ConcurrentHashMap<String, UserInfo>();
	
	public UserInfo(String name, String psw, int permissions) {
		this.name = name;
		this.psw = psw;
		this.permissions = permissions;
	}

	public String getName() {
		return name;
	}

	public int getPermissions() {
		return permissions;
	}

	public static void addUsers(String username, UserInfo ac) {
		users.putIfAbsent(username, ac);
	}
	
	public static ConcurrentHashMap<String, UserInfo> getUsers() {
		return users;
	}

	public String getPsw() {
		return psw;
	}
}
