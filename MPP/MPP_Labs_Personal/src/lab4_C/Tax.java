package lab4_C;

public enum Tax {

	FICA(.23), 
	State(.05), 
	Local(.01), 
	Medicare(.03), 
	SocialSecurity(.075);

	private double value;
	private Tax(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}
}
