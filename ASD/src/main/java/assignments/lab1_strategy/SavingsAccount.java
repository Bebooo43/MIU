package assignments.lab1_strategy;

public class SavingsAccount extends Account{

    public SavingsAccount(String accountNumber) {
        super(accountNumber, new SavingsAccountInterest());
    }
}
