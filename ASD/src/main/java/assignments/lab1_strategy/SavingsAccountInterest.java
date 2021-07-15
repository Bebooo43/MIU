package assignments.lab1_strategy;

public class SavingsAccountInterest implements InterestBehavior {

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
