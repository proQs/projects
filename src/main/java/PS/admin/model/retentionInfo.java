package PS.admin.model;

public class retentionInfo {

	private final String startDate;
	private final String retentionType;
	private final int createMembers;
	private final int retentionMembers;
	private final int prob;
	
	public retentionInfo(String startDate, String retentionType, int totalMembers, int retentionMembers, int prob) {
		this.startDate = startDate;
		this.retentionType = retentionType;
		this.createMembers = totalMembers;
		this.retentionMembers = retentionMembers;
		this.prob = prob;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getRetentionType() {
		return retentionType;
	}

	public int getCreateMembers() {
		return createMembers;
	}

	public int getRetentionMembers() {
		return retentionMembers;
	}

	public float getProb() {
		return prob;
	}

}
