package PS.admin.model;

public class ServerDBInfo {
	private final String logAddress;
	private final String logUser;
	private final String logPassWord;
	private final String dbAddress;
	private final String dbUser;
	private final String dbPassWord;
	
	public ServerDBInfo(String logAddress, String logUser, String logPassWord, String dbAddress, String dbUser, String dbPassWord) {
		this.logAddress = logAddress;
		this.logUser = logUser;
		this.logPassWord = logPassWord;
		this.dbAddress = dbAddress;
		this.dbUser = dbUser;
		this.dbPassWord = dbPassWord;
	}

	public String getLogAddress() {
		return logAddress;
	}

	public String getLogUser() {
		return logUser;
	}

	public String getLogPassWord() {
		return logPassWord;
	}

	public String getDbAddress() {
		return dbAddress;
	}

	public String getDbUser() {
		return dbUser;
	}

	public String getDbPassWord() {
		return dbPassWord;
	}
	
}
