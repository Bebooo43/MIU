package cs544.exercise16_1.bank.dao;

import java.util.*;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cs544.exercise16_1.bank.domain.Account;

public class AccountDAO implements IAccountDAO {
	
	private SessionFactory sf = HibernateUtil.getSessionFactory();

	public void saveAccount(Account account) {
		sf.getCurrentSession().persist(account.getCustomer());	
		sf.getCurrentSession().persist(account);		
	}

	public void updateAccount(Account account) {
		Account accountexist = loadAccount(account.getAccountnumber());
		if (accountexist != null) {
			sf.getCurrentSession().update(account);
		}
	}

	public Account loadAccount(long accountnumber) {
		Account account = sf.getCurrentSession().createQuery("from Account a left join fetch a.entryList where a.id = :id",Account.class).setParameter("id", accountnumber).uniqueResult();	
		return account;
	}

	public Collection<Account> getAccounts() {
		List<Account> accountList = sf.getCurrentSession().createQuery("From Account a left join fetch a.entryList",Account.class).list();	
		return accountList;
	}

}
