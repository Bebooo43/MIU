package final_project.solution.creditcard.paymentCalculators;

public interface PaymentCalculator {
    double calculateDuePayment(double balance);
    double calculateBalance(double prevBalance, double totalCredit, double totalCharge);
}
