package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        //P
        System.out.println("Enter total loan amount: ");
        long principal = scanner.nextLong();

        System.out.println("Enter yearly interest rate: ");
        double yearlyInterest = scanner.nextDouble();
        System.out.println("How long will you be paying off this loan?(Years): ");
        int yearsPaying = scanner.nextInt();

        //calculate (A)Monthly Payment using (P)rinciple, (I)nterest, and (N)Total Number of Payments

        //r
        double monthlyInterest = ((yearlyInterest / 12) / 100);

        //n
        int numberOfPayments = (yearsPaying * 12);

        double exponent = Math.pow(1 + monthlyInterest, numberOfPayments);

        //M
        double monthlyPayment = principal * (monthlyInterest * exponent / (exponent - 1));
        System.out.printf("Monthly Payment: $ %.2f\n" , monthlyPayment);

        double totalInterest = (monthlyPayment * numberOfPayments) - principal;
        System.out.printf("Total Interest: $ %.2f\n" , totalInterest);
    }
}