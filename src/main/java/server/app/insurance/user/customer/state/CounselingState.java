package server.app.insurance.user.customer.state;

public enum CounselingState {
    APPLIED("APPLIED"), 
    ACCEPTED_APPLY("ACCEPTED_APPLY"), 
    COMPLETED("COMPLETED");
	private String counselingState;
    
    CounselingState(String counselingState ) {
    	this.counselingState = counselingState;
    }
    public String getString() {
    	return this.counselingState;
    }
}
