package PS.admin.common;

public enum RetentionType {

	ONEDAY(1, "次日留存"),
	THREEDAY(3, "三日留存"),
	SEVEBDAY(7, "七日留存");
	
	private final int number;
	private final String type;
	RetentionType(int number, String type) {this.number = number; this.type = type; }
	public int number() {return number; }
	public String type() {return type; }
	
}
