package assignments.lab2_observer;

public class Logger implements Observer{

    private Account account;

    public Logger(Account account){
        this.account = account;
        account.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("[Logging] account ("+account.getAccountNumber()+") changed");
    }
}
