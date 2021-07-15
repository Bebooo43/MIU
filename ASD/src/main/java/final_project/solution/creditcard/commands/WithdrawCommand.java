package final_project.solution.creditcard.commands;

import final_project.solution.creditcard.CreditAccountService;
import final_project.solution.framework.ui.UIControl;
import final_project.solution.framework.ui.Command;

public class WithdrawCommand implements Command {
    @Override
    public void execute(UIControl control) {
        CreditAccountService.getInstance().withdraw(control.getAccountNumber(), Double.parseDouble(control.getAmount()));
    }
}
