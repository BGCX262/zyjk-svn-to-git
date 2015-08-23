package synch.beans;

import java.util.List;

public class Request {
	
	private Verification verification;
	
	private List<Factor> factors;

	public List<Factor> getFactors() {
		return factors;
	}

	public void setFactors(List<Factor> factors) {
		this.factors = factors;
	}

	public Verification getVerification() {
		return verification;
	}

	public void setVerification(Verification verification) {
		this.verification = verification;
	}

	
}
