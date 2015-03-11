package PS.admin.model;

public class retentionInfo {

	public final String startDate;
	public final int retentionType;
	public final int createMembers;
	public final int retentionMembers;
	public final float Prob;
	
	public retentionInfo(String startDate, int retentionType, int totalMembers, int retentionMembers, float Prob) {
		this.startDate = startDate;
		this.retentionType = retentionType;
		this.createMembers = totalMembers;
		this.retentionMembers = retentionMembers;
		this.Prob = Prob;
	}
}
