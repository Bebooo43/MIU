package lab4_E;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	private String name;
	private List<Account> accounts;
	private double updatedBalanceSum;
	public Employee(String name) {
		this.name = name;
		accounts = new ArrayList<Account>();
	}
	
	public double computeUpdatedBalanceSum() {
		updatedBalanceSum= 0 ;
		accounts.stream().forEach((acct) ->{
			updatedBalanceSum += acct.computeUpdatedBalance();
		});
		return updatedBalanceSum;
	}
	
	public String getName() {
		return name;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
}
