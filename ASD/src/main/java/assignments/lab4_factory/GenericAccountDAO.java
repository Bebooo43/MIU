package assignments.lab4_factory;

import java.util.Collection;

public interface GenericAccountDAO {
    void saveAccount(Account account);
    void updateAccount(Account account);
    Account loadAccount(String accountnumber);
    Collection<Account> getAccounts();
}
