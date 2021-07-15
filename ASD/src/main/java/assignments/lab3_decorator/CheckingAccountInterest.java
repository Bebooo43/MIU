package assignments.lab3_decorator;

public class CheckingAccountInterest implements InterestBehavior {

    private static final CheckingAccountInterest instance = new CheckingAccountInterest();
    private CheckingAccountInterest(){ }

    public static CheckingAccountInterest getInstance() {
        return instance;
    }

    @Override
    public double interest(Account account) {
        double balance = account.getBalance();
        double amount = 0;
        if (balance < 1000)
            amount = balance * 0.015;
        else if (balance > 1000)
            amount = balance * 0.025;
        return amount;
    }
}
