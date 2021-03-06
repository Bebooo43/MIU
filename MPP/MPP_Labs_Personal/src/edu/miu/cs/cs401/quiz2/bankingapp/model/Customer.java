package edu.miu.cs.cs401.quiz2.bankingapp.model;

import java.time.LocalDate;

public class Customer {

	private String customerId;
	private Account account;
	private String name;
	private LocalDate dayOfBirth;
	
	public Customer(String customerId,String name, LocalDate dayOfBirth, Long accountNo, double balance) {
		this.customerId = customerId;
		this.name = name;
		this.dayOfBirth = dayOfBirth;
		account = new Account(this,accountNo, balance);
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDayOfBirth() {
		return dayOfBirth;
	}
	public void setDayOfBirth(LocalDate dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("[CustomerId: %s, Name: %s, Day of Birth: %s - ", customerId, name,dayOfBirth)+ account.toString() +"]";
	}
	
}
