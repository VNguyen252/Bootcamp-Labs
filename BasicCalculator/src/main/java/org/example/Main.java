package org.example;
import java.util.Scanner;

public class Main {

//    private static int quotient;

    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter the first number: ");
//        float firstNumber = scanner.nextFloat();
//        scanner.nextLine();
//
//        System.out.print("Enter the second number: ");
//        float secondNumber = scanner.nextFloat();
//        scanner.nextLine();
//
//        System.out.print("""
//
//                |Possible Calculations|
//
//                   [A]dd
//                   [S]ubtract
//                   [M]ultiply
//                   [D]ivide
//
//                |Please select an option|:""");
//
//
//        String mathOption= scanner.nextLine();
//
//
//
//        if (mathOption.equalsIgnoreCase("A")){
//            System.out.println(firstNumber + "+" + secondNumber + " = " + (firstNumber + secondNumber));
//
//
//        }
//        else if (mathOption.equalsIgnoreCase("S")){
//            System.out.println(firstNumber + "-" + secondNumber + " = " + (firstNumber - secondNumber));
//
//        }
//        else if (mathOption.equalsIgnoreCase("M")){
//            System.out.println(firstNumber + "*" + secondNumber + " = " + (firstNumber * secondNumber));
//
//        }
//
//        else if (mathOption.equalsIgnoreCase("D")){
//            System.out.println(firstNumber + "/" + secondNumber + " = " + (firstNumber / secondNumber));
//        }
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give me two numbers to add together: ");
        System.out.println("Enter the first number: ");
        int firstNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the second number: " );
        int secondNumber = scanner.nextInt();
        scanner.nextLine();



        System.out.print("""

                |Possible Calculations|

                   [A]dd
                   [S]ubtract
                   [M]ultiply
                   [D]ivide

                |Please select an option|:""");
        String mathOption= scanner.nextLine();

        if (mathOption.equalsIgnoreCase("A")) {
            int sum = addTwoNumbers(firstNumber, secondNumber);
        }
        else if (mathOption.equalsIgnoreCase("S")) {
            int difference = subtractTwoNumbers(firstNumber, secondNumber);
        }
        else if (mathOption.equalsIgnoreCase("M")) {
            int product = multiplyTwoNumbers(firstNumber, secondNumber);
        }
        else if (mathOption.equalsIgnoreCase("D")) {
            int quotient = dividTwoNumbers(firstNumber, secondNumber);
        }





    }
    public  static int addTwoNumbers(int firstNumber, int secondNumber){
        int sum = firstNumber + secondNumber;
        System.out.println("The sum is: " + sum);
        return sum;
    }
    public static int subtractTwoNumbers(int firstNumber, int secondNumber){
        int difference = firstNumber - secondNumber;
        System.out.println("The difference is: " + difference);
        return difference;
    }
    public static int multiplyTwoNumbers(int firstNumber, int secondNumber){
        int product = firstNumber * secondNumber;
        System.out.println("The product is: " + product);
        return product;
    }
    public static int dividTwoNumbers(int firstNumber, int secondNumber ){
        int quotient = firstNumber / secondNumber;
        System.out.println("The quotient is: ");
        return quotient;
    }

}