package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //declare deposit, interest rate, and number of years from the user

        //P
        System.out.println("How much would you like to deposit?: ");
        double deposit = scanner.nextDouble();

        //r
        System.out.println("What is your annual interest rate?: ");
        double annualInterest = scanner.nextDouble() / 100;

        //t
        System.out.println("How long do you want to let this bad boy cook?");
        int numberOfYears = scanner.nextInt();

        double dailyInterest = annualInterest / 365;

        //n
        int timesCompounded = 365;

        double firstHalf = (1 + annualInterest / timesCompounded);
        double secondHalf = (timesCompounded * numberOfYears);


        double exponent = Math.pow(firstHalf , secondHalf);

        //FV
        double futureValue = deposit * exponent;

        System.out.printf("You're CD will be worth: $ %.2f\n" , futureValue);

        double totalInterest = futureValue - deposit;
        System.out.printf("Your total interest gained is: $ %.2f\n", totalInterest);


    }
}