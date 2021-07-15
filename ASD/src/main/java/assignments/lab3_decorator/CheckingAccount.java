package assignments.lab3_decorator;

public class CheckingAccount extends Account {

    public CheckingAccount(String accountNumber) {
        super(accountNumber, CheckingAccountInterest.getInstance());
    }
}
