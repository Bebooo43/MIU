package final_project.solution.banking.interestCalculators;

import final_project.solution.framework.InterestCalculator;

public class CompanySavingInterestCalculator implements InterestCalculator {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.07;
    }
}
