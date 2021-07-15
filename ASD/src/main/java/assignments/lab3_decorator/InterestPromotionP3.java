package assignments.lab3_decorator;

public class InterestPromotionP3 extends InterestPromotionDecorator{

    public InterestPromotionP3(InterestBehavior interestBehavior) {
        super(interestBehavior);
    }

    @Override
    public double interest(Account account) {
        return getInterestBehavior().interest(account) + account.getBalance() * 0.03;
    }
}
