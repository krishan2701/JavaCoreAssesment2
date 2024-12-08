import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input variables
        System.out.print("Enter the principal loan amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate (in %): ");
        double annualInterestRate = scanner.nextDouble();

        System.out.print("Enter the loan tenure (in years): ");
        int loanTenureInYears = scanner.nextInt();
        int loanTenureInMonths = loanTenureInYears * 12;

        System.out.print("Enter the monthly SIP investment: ");
        double sipInvestment = scanner.nextDouble();

        System.out.print("Enter the annual return rate on SIP (in %): ");
        double sipAnnualReturnRate = scanner.nextDouble();

        // Calculate EMI
        double emi = Calculator.calculateEMI(principal, annualInterestRate, loanTenureInMonths);

        // Calculate the total payment for the home loan
        double totalHomeLoanPaid = emi * loanTenureInMonths;

        // Calculate Asset Appreciation and Depreciation
        double finalAssetValueWithAppreciation = Calculator.calculateAssetAppreciation(principal, loanTenureInYears);
        double finalAssetValueWithDepreciation = Calculator.calculateDepreciation(principal, loanTenureInYears);

        // Calculate SIP Returns
        double sipReturns = Calculator.calculateSIPReturns(sipInvestment, sipAnnualReturnRate, loanTenureInMonths);

        // Summary
        System.out.println("\nSUMMARY:");
        System.out.println("-------------------------------------------------");
        System.out.println("EMI for Home Loan (Monthly): " + emi);
        System.out.println("Total Payment made over the loan tenure (Home Loan): " + totalHomeLoanPaid);
        System.out.println("Final Asset Value with Appreciation (after " + loanTenureInYears + " years): " + finalAssetValueWithAppreciation);
        System.out.println("Final Asset Value with Depreciation (after " + loanTenureInYears + " years): " + finalAssetValueWithDepreciation);
        System.out.println("SIP Investment Returns (after " + loanTenureInYears + " years): " + sipReturns);

        // Comparing the two options
        if (sipReturns > finalAssetValueWithAppreciation) {
            System.out.println("SIP Investment is more profitable than buying the property.");
        } else if (sipReturns < finalAssetValueWithAppreciation) {
            System.out.println("Buying the property is more profitable than SIP investment.");
        } else {
            System.out.println("Both options are equally profitable.");
        }

        scanner.close();
    }
}
