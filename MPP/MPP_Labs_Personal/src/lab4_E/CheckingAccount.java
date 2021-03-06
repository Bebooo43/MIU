package lab4_E;

public class CheckingAccount extends Account{

	private String id;
	private Double monthFee;
	private Double balance;
	
	public CheckingAccount(String id, Double monthFee, Double balance) {
		this.id = id;
		this.monthFee = monthFee;
		this.balance = balance;
	}

	@Override
	public double computeUpdatedBalance() {
		 return balance - monthFee;
	}

	@Override
	public String getId() {
		return id;
	}
	@Override
	public Double getBalance() {
		return balance;
	}

}
