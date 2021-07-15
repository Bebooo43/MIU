package final_project.solution.banking;

import final_project.solution.framework.Account;
import final_project.solution.framework.InterestCalculator;

public class SavingAccount extends Account {
    public SavingAccount(InterestCalculator interestCalculator) {
        super(interestCalculator);
    }

    @Override
    public String getAccountType() {
        return AccountTypes.Saving.name();
    }
}
