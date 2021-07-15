package assignments.lab3_decorator;


public class Application {
	public static void main(String[] args) {
		AccountService accountService = new AccountServiceImpl();

		// create 2 accounts;
		Account acc = accountService.createAccount(new CheckingAccount("1263862"), "Frank Brown");
		Account acc2 = accountService.createAccount(new SavingsAccount("4253892"), "John Doe");

		// use account 1;
		accountService.deposit("1263862", 240);
		accountService.deposit("1263862", 529);
		accountService.withdraw("1263862", 230);

		// use account 2;
		accountService.deposit("4253892", 12450);
		accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");

		//decorator
		InterestBehavior it = acc.getInterestBehavior();
		it = new InterestPromotionP1(it);
		it = new InterestPromotionP2(it);
		it = new InterestPromotionP3(it);
		acc.setInterestBehavior(it);

		// add interest
		accountService.addInterest();

		// show balances
		for (Account account : accountService.getAllAccounts()) {
			Customer customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountNumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("Account Type: " + account.getClass().getSimpleName());

			System.out.println("-Date-------------------------" 
					+ "-Description------------------" 
					+ "-Amount-------------");
			
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", 
						entry.getDate().toString(), 
						entry.getDescription(),
						entry.getAmount());

			}
			
			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}

		//Applying decorator
		/*System.out.println("--------------DECORATOR-------------");

		Account acc = new CheckingAccount("1");
		acc.deposit(200);
		System.out.println(acc.getAccountNumber()+" $"+acc.calculateInterest());

		Account acc2 = new CheckingAccount("2");
		acc2.deposit(200);
		acc2 = new InterestPromotionP1(acc2);
		acc2 = new InterestPromotionP2(acc2);
		acc2 = new InterestPromotionP3(acc2);
		System.out.println(acc2.getAccountNumber()+" $"+acc2.calculateInterest());*/
	}

}
