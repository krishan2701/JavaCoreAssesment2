public class Calculator {

    public static double calculateEMI(double principal, double annualInterestRate, int tenureInMonths) {
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        return (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenureInMonths)) /
                (Math.pow(1 + monthlyInterestRate, tenureInMonths) - 1);
    }

    public static double calculateSIPReturns(double monthlyInvestment, double annualReturnRate, int months) {
        double rate = annualReturnRate / 12 / 100;
        double futureValue = 0;
        for (int i = 1; i <= months; i++) {
            futureValue += monthlyInvestment * Math.pow(1 + rate, months - i);
        }
        return futureValue;
    }

    public static double calculateAssetAppreciation(double initialPrice, int years) {
        return initialPrice * Math.pow(1 + Constants.APPRECIATION_RATE, years);
    }

    public static double calculateDepreciation(double initialPrice, int years) {
        return initialPrice * Math.pow(1 - Constants.DEPRECIATION_RATE, years);
    }
}
