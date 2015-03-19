package PS.admin.model;

public class retentionInfo {

	private final int createMembers;
	private final int loginMembers;
	private final int retentionType;
	private final int retentionMembers;
	private final int prob;
	
	public retentionInfo(int createMembers, int loginMembers, int retentionType, int retentionMembers, int prob) {
		this.createMembers = createMembers;
		this.loginMembers = loginMembers;
		this.retentionType = retentionType;
		this.retentionMembers = retentionMembers;
		this.prob = prob;
	}

	public int getCreateMembers() {
		return createMembers;
	}

	public int getLoginMembers() {
		return loginMembers;
	}

	public int getRetentionType() {
		return retentionType;
	}

	public int getRetentionMembers() {
		return retentionMembers;
	}

	public int getProb() {
		return prob;
	}

}
