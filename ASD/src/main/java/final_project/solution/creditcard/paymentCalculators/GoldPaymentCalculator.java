package final_project.solution.creditcard.paymentCalculators;

public class GoldPaymentCalculator implements PaymentCalculator {
    @Override
    public double calculateDuePayment(double balance) {
        return balance * 0.1;
    }

    @Override
    public double calculateBalance(double prevBalance, double totalCredit, double totalCharge) {
        return prevBalance - totalCredit + totalCharge + 0.06 * (prevBalance - totalCredit);
    }
}
