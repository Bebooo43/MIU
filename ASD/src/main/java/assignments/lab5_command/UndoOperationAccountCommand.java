package assignments.lab5_command;

public class UndoOperationAccountCommand implements Command {

    Account account;

    public UndoOperationAccountCommand(Account account){
        this.account = account;
    }

    @Override
    public void undo() {
        if(account.getEntryList().isEmpty())
            System.err.println("No operations do undo...");
        else
            account.undoLastOperation();
    }
}
