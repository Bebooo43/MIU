package edu.miu.cs.cs401.quiz2.bankingapp.model;

public class Account {

	private Customer customer;
	private Long accountNo;
	private double balance;
	
	Account(Customer customer, Long accountNo, double balance) {
		this.customer = customer;
		this.accountNo = accountNo;
		this.balance = balance;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return String.format("[ AccountNo: %d, Balance: %f", accountNo,balance) + "]";
	}
}
