package assignments.lab2_observer;

public class EmailSender implements Observer{

    private Account account;

    public EmailSender(Account account){
        this.account = account;
        account.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("[Sending email] account ("+account.getAccountNumber()+") changed");
    }
}
