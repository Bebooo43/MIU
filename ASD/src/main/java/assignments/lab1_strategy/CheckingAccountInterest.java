package assignments.lab1_strategy;

public class CheckingAccountInterest implements InterestBehavior {

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
