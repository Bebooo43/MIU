package final_project.solution.banking;

import final_project.solution.framework.Account;
import final_project.solution.framework.InterestCalculator;

public class CheckingAccount extends Account {
    public CheckingAccount(InterestCalculator interestCalculator) {
        super(interestCalculator);
    }

    @Override
    public String getAccountType() {
        return AccountTypes.Checking.name();
    }
}
