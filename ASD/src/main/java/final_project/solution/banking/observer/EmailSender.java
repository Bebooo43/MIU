package final_project.solution.banking.observer;

import final_project.solution.framework.*;

public class EmailSender implements Observer {
    private AccountService actsvc;

    public EmailSender(AccountService accountService) {
        this.actsvc = accountService;
    }

    @Override
    public void update() {
        if (actsvc.getOperation() == AccountOperation.WITHDREW || actsvc.getOperation() == AccountOperation.DEPOSITED) {
            Account account = actsvc.getChangedAccount();
            double amount = actsvc.getChangedAmount();
            if (account.getCustomer() instanceof Personal && (amount <= 500 && account.getBalance() > 0)) {
                return;
            }
            System.out.println("Sending email to: " + account.getCustomer().getEmail() + " Operation in account (" + account.getAccountNumber() + ") amount = \n" + amount + " - " + actsvc.getOperation());
        }
    }
}
