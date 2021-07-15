package final_project.solution.framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Account {
    private Customer customer;
    private String accountNumber;
    private List<AccountEntry> accountEntries;
    private InterestCalculator interestCalculator;

    public Account(InterestCalculator interestCalculator) {
        this.interestCalculator = interestCalculator;
        this.accountEntries = new ArrayList<>();
    }

    public void setInterestCalculator(InterestCalculator interestCalculator) {
        this.interestCalculator = interestCalculator;
    }

    public abstract String getAccountType();

    public double getBalance() {
        return accountEntries.stream().mapToDouble(AccountEntry::getAmount).sum();
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit", null);
        addAccountEntry(entry);
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "withdraw", null);
        addAccountEntry(entry);
    }

    public void interest() {
        if (interestCalculator != null) {
            double interest = interestCalculator.calculateInterest(getBalance());
            AccountEntry entry = new AccountEntry(interest, "interest", null);
            addAccountEntry(entry);
        }

    }

    private void addAccountEntry(AccountEntry entry) {
        accountEntries.add(entry);
    }

    public Collection<AccountEntry> getAccountEntries() {
        return accountEntries;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
