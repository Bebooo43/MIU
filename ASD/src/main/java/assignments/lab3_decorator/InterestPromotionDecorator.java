package assignments.lab3_decorator;

public abstract class InterestPromotionDecorator implements InterestBehavior{

    private InterestBehavior interestBehavior;

    public InterestPromotionDecorator(InterestBehavior interestBehavior){
        this.interestBehavior = interestBehavior;
    }

    public InterestBehavior getInterestBehavior() {
        return interestBehavior;
    }

    public void setInterestBehavior(InterestBehavior interestBehavior) {
        this.interestBehavior = interestBehavior;
    }

}
