package final_project.solution.banking.commands;

import final_project.solution.banking.BankingAccountService;
import final_project.solution.framework.ui.UIControl;
import final_project.solution.framework.ui.Command;

public class AddPersonalAccountCommand implements Command {
    @Override
    public void execute(UIControl control) {
        BankingAccountService accountService = BankingAccountService.getInstance();
        accountService.createAccount(control.getAccountNumber(), control.getCustomer(), control.getAccountType());
    }
}
