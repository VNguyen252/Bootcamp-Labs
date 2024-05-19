package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give me two numbers to add together: ");
        System.out.println("First number please");
        int firstNumber = scanner.nextInt();
        System.out.println("Second number please");
        int secondNumber = scanner.nextInt();

        //calling the addTwoNumbers
        int sum = addTwoNumbers(firstNumber, secondNumber);

        System.out.println("The sum is: " + sum);

    }

    //DRY Principle

    //how to write a function
    public static int addTwoNumbers(int firstNumber, int secondNumber) {
        int sum = firstNumber + secondNumber;
        return sum;
    }

    //What if I don't want to return anything???

    public static void greeting(String name) {
        System.out.println("Good Morning " + name + "!");
    }


}

