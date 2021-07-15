package assignments.lab3_decorator;

import java.util.Collection;

public interface AccountService {
    Account createAccount(Account account, String customerName);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    void addInterest();
    void addPromotion(InterestPromotionDecorator promotion);
}
