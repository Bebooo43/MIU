package final_project.solution.banking;

import final_project.solution.banking.interestCalculators.CompanyCheckingInterestCalculator;
import final_project.solution.banking.interestCalculators.CompanySavingInterestCalculator;
import final_project.solution.banking.interestCalculators.PersonalCheckingInterestCalculator;
import final_project.solution.banking.interestCalculators.PersonalSavingInterestCalculator;
import final_project.solution.banking.observer.EmailSender;
import final_project.solution.framework.Account;
import final_project.solution.framework.AccountService;
import final_project.solution.framework.Customer;
import final_project.solution.framework.Personal;

public class BankingAccountService extends AccountService {
    private static volatile BankingAccountService instance;

    private BankingAccountService() {
        super(BankingAccountDAO.getInstance());
        this.registerObserver(new EmailSender(this));
    }

    @Override
    public Account initAccount(String accountType, Customer customer) {
        if (customer instanceof Personal) {
            if (AccountTypes.valueOf(accountType) == AccountTypes.Checking) {
                return new CheckingAccount(new PersonalCheckingInterestCalculator());
            }
            return new SavingAccount(new PersonalSavingInterestCalculator());
        }
        if (AccountTypes.valueOf(accountType) == AccountTypes.Checking) {
            return new CheckingAccount(new CompanyCheckingInterestCalculator());
        }
        return new SavingAccount(new CompanySavingInterestCalculator());
    }

    public static BankingAccountService getInstance() {
        if (instance == null) {
            synchronized (BankingAccountService.class) {
                if (instance == null) {
                    instance = new BankingAccountService();
                }
            }
        }
        return instance;
    }
}
