package assignments.lab3_decorator;

public class SavingsAccountInterest implements InterestBehavior {

    private static final SavingsAccountInterest instance = new SavingsAccountInterest();
    private SavingsAccountInterest(){ }

    public static SavingsAccountInterest getInstance() {
        return instance;
    }

    @Override
    public double interest(Account account) {
        double balance = account.getBalance();
        double amount = 0;
        if(balance < 1000)
            amount = balance * 0.01;
        else if (balance > 1000 && balance < 5000)
            amount = balance * 0.02;
        else if (balance > 5000)
            amount =balance * 0.04;

        return amount;
    }
}
