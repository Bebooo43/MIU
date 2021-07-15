package assignments.lab3_decorator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Account {
	private Customer customer;
	private String accountNumber;
	private InterestBehavior interestBehavior;
	private List<AccountEntry> entryList = new ArrayList<>();

	public Account(String accountNumber, InterestBehavior ib) {
		this.accountNumber = accountNumber;
		this.interestBehavior = ib;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : entryList) {
			balance += entry.getAmount();
		}
		return balance;
	}

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
		entryList.add(entry);
	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
		entryList.add(entry);
	}

	private void addEntry(AccountEntry entry) {
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description) {
		AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		
		entryList.add(fromEntry);
		
		toAccount.addEntry(toEntry);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	public double calculateInterest() {
		return interestBehavior.interest(this);
	}

	public void performInterest(){
		AccountEntry entry = new AccountEntry(calculateInterest(), "interest", "", "");
		entryList.add(entry);
	}

	public InterestBehavior getInterestBehavior() {
		return interestBehavior;
	}
	public void setInterestBehavior(InterestBehavior interestBehavior) {
		this.interestBehavior = interestBehavior;
	}
}
