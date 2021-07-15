package final_project.solution.creditcard.commands;

import final_project.solution.creditcard.CreditAccountService;
import final_project.solution.framework.ui.Command;
import final_project.solution.framework.ui.UIControl;

public class ReportCommand implements Command {
    @Override
    public void execute(UIControl control) {
        CreditAccountService.getInstance().buildReport();
    }
}
