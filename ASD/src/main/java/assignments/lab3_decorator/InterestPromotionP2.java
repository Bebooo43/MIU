package assignments.lab3_decorator;

public class InterestPromotionP2 extends InterestPromotionDecorator{

    public InterestPromotionP2(InterestBehavior interestBehavior) {
        super(interestBehavior);
    }

    @Override
    public double interest(Account account) {
        return getInterestBehavior().interest(account) + account.getBalance() * 0.02;
    }
}
