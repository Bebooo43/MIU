package final_project.solution.framework.ui;

import final_project.solution.framework.Customer;

public interface UIControl {
    void init(String title, UIConfig config);
    void setAddPersonalAccountCommand(Command addAccountCommand);
    void setAddCompanyAccountCommand(Command addAccountCommand);
    void setReportCommand(Command reportCommand);
    void setAddInterestCommand(Command addInterestCommand);
    void setDepositCommand(Command depositCommand);
    void setWithdrawCommand(Command withdrawCommand);
    void setVisible(boolean value);

    String getAccountType();
    String getAccountNumber();
    Customer getCustomer();
    String getAmount();
}
