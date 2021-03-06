package lab4_E;

public class SavingsAccount extends Account{

	private String id;
	private Double interestRate;
	private Double balance;
	
	public SavingsAccount(String id, Double interestRate,Double balance) {
		this.id = id;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	@Override
	public String getId() {
		return id;
	}
	@Override
	public Double getBalance() {
		return balance;
	}
	
	@Override
	public double computeUpdatedBalance() {
		return balance + (balance * interestRate);
	}
	
}
