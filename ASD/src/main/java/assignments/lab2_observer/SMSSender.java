package assignments.lab2_observer;

public class SMSSender implements Observer{
    private Account account;

    public SMSSender(Account account){
        this.account = account;
        account.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("[Sending SMS] account ("+account.getAccountNumber()+") changed");
    }
}
