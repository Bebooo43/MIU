package assignments.lab1_strategy;

public class CheckingAccount extends Account {

    public CheckingAccount(String accountNumber) {
        super(accountNumber, new CheckingAccountInterest());
    }
}
