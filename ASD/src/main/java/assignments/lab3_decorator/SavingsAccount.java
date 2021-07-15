package assignments.lab3_decorator;

public class SavingsAccount extends Account {


    public SavingsAccount(String accountNumber) {
        super(accountNumber, SavingsAccountInterest.getInstance());
    }
}
