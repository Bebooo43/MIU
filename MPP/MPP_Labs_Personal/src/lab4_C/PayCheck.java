package lab4_C;

public final class PayCheck {
	
	private final Double grossPay;
	private final Tax  fica;
	private final Tax  state;
	private final Tax  local;
	private final Tax  medicare;
	private final Tax  socialSecurity;
	
	public PayCheck(Double  grossPay, Tax  fica, Tax  state, Tax  local, Tax  medicare, Tax  socialSecurity) {
		this.grossPay = grossPay;
		this.fica = fica;
		this.state = state;
		this.local = local;
		this.medicare = medicare;
		this.socialSecurity = socialSecurity;
	}
	
	public void print() {
		System.out.println(this);
	}
	
	public double getNetPay() {
		return grossPay - grossPay * fica.getValue()
						- grossPay * state.getValue()
						- grossPay * local.getValue()
						- grossPay * medicare.getValue()
						- grossPay * socialSecurity.getValue();
	}

	public Double getGrossPay() {
		return grossPay;
	}


	@Override
	public String toString() {
		return "PayCheck [grossPay=" + grossPay + ", fica=" + fica + ", state=" + state + ", local=" + local
				+ ", medicare=" + medicare + ", socialSecurity=" + socialSecurity + "]";
	}

}
