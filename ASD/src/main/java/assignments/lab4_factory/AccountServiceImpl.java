package assignments.lab4_factory;

import java.util.Collection;

public class AccountServiceImpl implements AccountService {
	private GenericAccountDAO genericAccountDAO;
	
	public AccountServiceImpl(GenericAccountDAO dao){
		this.genericAccountDAO = dao;
	}

	public Account createAccount(String accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		
		genericAccountDAO.saveAccount(account);
		
		return account;
	}

	public void deposit(String accountNumber, double amount) {
		Account account = genericAccountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		
		genericAccountDAO.updateAccount(account);
	}

	public Account getAccount(String accountNumber) {
		Account account = genericAccountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return genericAccountDAO.getAccounts();
	}

	public void withdraw(String accountNumber, double amount) {
		Account account = genericAccountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		genericAccountDAO.updateAccount(account);
	}

	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = genericAccountDAO.loadAccount(fromAccountNumber);
		Account toAccount = genericAccountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		genericAccountDAO.updateAccount(fromAccount);
		genericAccountDAO.updateAccount(toAccount);
	}

	public void setGenericAccountDAO(GenericAccountDAO genericAccountDAO) {
		this.genericAccountDAO = genericAccountDAO;
	}
}
