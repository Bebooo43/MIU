package final_project.solution.creditcard.commands;

import final_project.solution.creditcard.CreditAccountService;
import final_project.solution.framework.ui.UIControl;
import final_project.solution.framework.ui.Command;

public class DepositAccountCommand implements Command {
    @Override
    public void execute(UIControl control) {
        CreditAccountService.getInstance().deposit(control.getAccountNumber(),Double.parseDouble(control.getAmount()));
    }
}
