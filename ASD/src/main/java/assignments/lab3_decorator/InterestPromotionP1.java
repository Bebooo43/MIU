package assignments.lab3_decorator;

public class InterestPromotionP1 extends InterestPromotionDecorator{

    public InterestPromotionP1(InterestBehavior interestBehavior) {
        super(interestBehavior);
    }

    @Override
    public double interest(Account account) {
        return getInterestBehavior().interest(account) + account.getBalance() * 0.01;
    }
}
