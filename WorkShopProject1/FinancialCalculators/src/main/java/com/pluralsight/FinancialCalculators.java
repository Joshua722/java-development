package com.pluralsight;
import java.util.Scanner;
public class FinancialCalculators {
    public static Scanner myScanner = new Scanner(System.in);
    public static void MortgageCalculator (){

        System.out.println("Here's the Mortgage Calculator! ");

        System.out.print("What is your loan amount : ");
        double loanAmount = myScanner.nextDouble();

        System.out.print("What is your interest rate : ");
        double interestRate = myScanner.nextDouble();
        // interest per month
        double userInterestRate = interestRate / 1200 ;
        int compoundsPerYear = 12;


        System.out.print("Last question how long is your loan duration for in years : ");
        double loanDuration = myScanner.nextDouble();
        double userLoanDuration = loanDuration * 12 ;

        double loanAmountInterest = loanAmount * userInterestRate / (1 - Math.pow( 1 + userInterestRate, -1 * userLoanDuration)) ;
        double totalAmountInterest = (loanAmountInterest * userLoanDuration) - loanAmount;

        System.out.printf("Here are your results: %.2f loan at %.2f%% for %.0f years, you would have %.2f /mo payment with a total interest amount of %.2f .", loanAmount, interestRate, loanDuration, loanAmountInterest, totalAmountInterest);
    }
        public static void CDCalculator(){


        }



}
