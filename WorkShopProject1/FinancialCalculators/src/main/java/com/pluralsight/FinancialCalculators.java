package com.pluralsight;
import java.util.Scanner;
public class FinancialCalculators {
    public static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("What kind of calculator do you need today?");
        System.out.println("\t Mortgage Calculator (1) ");
        System.out.println("\t CD Calculator (2) ");
        System.out.println("\t Ordinary Annuity Calculator (3)");

        int userChoice = myScanner.nextInt();

        if(userChoice == 1){
            MortgageCalculator();
        }
        else if(userChoice == 2){
            CDCalculator();
        }
        else if(userChoice == 3){
            OACalculator();
        }
    }
    public static void MortgageCalculator (){

        System.out.println("Here's the Mortgage Calculator! ");

        System.out.print("What is your loan amount : ");
            double loanAmount = myScanner.nextDouble();

        System.out.print("What is your interest rate : ");
            double interestRate = myScanner.nextDouble();
        // interest per month
        double userInterestRate = interestRate / 1200 ;

        System.out.print("Last question how long is your loan duration for in years : ");
            double loanDuration = myScanner.nextDouble();
        double userLoanDuration = loanDuration * 12 ;

        double loanAmountInterest = loanAmount * userInterestRate / (1 - Math.pow( 1 + userInterestRate, -1 * userLoanDuration)) ;
        double totalAmountInterest = (loanAmountInterest * userLoanDuration) - loanAmount;

        System.out.printf("Here are your results: $ %.2f loan at %.2f%% for %.0f years, you would have $ %.2f /mo payment with a total interest amount of $ %.2f .", loanAmount, interestRate, loanDuration, loanAmountInterest, totalAmountInterest);
    }
        public static void CDCalculator(){
            System.out.println("Here's the CD Calculator! ");

            System.out.print("How much do you want to deposit? ");
                double initialDeposit = myScanner.nextDouble();

            System.out.print("How much interest do you want to earn? ");
                double annualInterestRate = myScanner.nextDouble();

            System.out.print("For how long do you want to invest for? (years) ");
                double investYears = myScanner.nextDouble();

            // variables
                double dailyInterestAmount = annualInterestRate / 100 ;
                double totalAmount = initialDeposit * Math.pow(1 + dailyInterestAmount, investYears);
                double totalAmountInterest = totalAmount - initialDeposit;

            System.out.printf("If you deposit $ %.2f in a CD that earns %.2f%% interest and matures for %.2f years, your CD ending balance will be $ %.2f and you would have earned $ %.2f in interest.", initialDeposit, annualInterestRate, investYears, totalAmount, totalAmountInterest);
        }

        public static void OACalculator(){
            //User Input
            System.out.println("Here's the Ordinary Annuity Calculator! ");

            System.out.print("How much do you want to get paid per month? ");
                double monthlyPay = myScanner.nextDouble();

            System.out.print("For how long do you want to get paid for? (years) ");
                double payDuration = myScanner.nextDouble();

            System.out.print("What is your expected interest rate? ");
                double interestRate = myScanner.nextDouble();
             //var

             double monthsPaid = payDuration * 12;
             double userInvestment = monthlyPay * ((1 - Math.pow((1 + (interestRate / 1200 )), monthsPaid * -1)) / (interestRate / 1200));

             System.out.printf("To get that monthly payment, you would need to invest $ %.2f right now!", userInvestment);



        }



}
