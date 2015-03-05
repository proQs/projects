package PS.admin.common;

public enum LoginInfo {

	OK_LOGIN(0),
	NO_ADMINISTRATOR(1),
	ERROR_PSW(2);
	
	private final int number;
	LoginInfo(int number) {this.number = number; }
	public int number() {return number; }
	
}
