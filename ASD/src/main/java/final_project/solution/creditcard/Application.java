package final_project.solution.creditcard;

import final_project.solution.creditcard.commands.*;
import final_project.solution.framework.ui.MainFrm;
import final_project.solution.framework.ui.UIControl;

import javax.swing.*;

public class Application {

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIControl frm = MainFrm.getInstance();
            frm.init("Credit Card Application", new CreditUIConfig());

            //commands
            frm.setAddPersonalAccountCommand(new AddPersonalAccountCommand());
            frm.setAddCompanyAccountCommand(new AddCompanyAccountCommand());
            frm.setDepositCommand(new DepositAccountCommand());
            frm.setWithdrawCommand(new WithdrawCommand());
            frm.setAddInterestCommand(new AddInterestCommand());
            frm.setReportCommand(new ReportCommand());

            //Create a new instance of our application's frame, and make it visible.
            frm.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
