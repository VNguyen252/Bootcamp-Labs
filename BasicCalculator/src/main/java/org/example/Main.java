package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        float firstNumber = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Enter the second number: ");
        float secondNumber = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("""
               
                |Possible Calculations|
                
                   [A]dd 
                   [S]ubtract 
                   [M]ultiply 
                   [D]ivide
                
                |Please select an option|: """);


        String mathOption= scanner.nextLine();



        if (mathOption.equalsIgnoreCase("A")){
            System.out.println(firstNumber + "+" + secondNumber + " = " + (firstNumber + secondNumber));


        }
        else if (mathOption.equalsIgnoreCase("S")){
            System.out.println(firstNumber + "-" + secondNumber + " = " + (firstNumber - secondNumber));

        }
        else if (mathOption.equalsIgnoreCase("M")){
            System.out.println(firstNumber + "*" + secondNumber + " = " + (firstNumber * secondNumber));

        }

        else if (mathOption.equalsIgnoreCase("D")){
            System.out.println(firstNumber + "/" + secondNumber + " = " + (firstNumber / secondNumber));
        }


    }
}