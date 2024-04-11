package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your sign?");
        String userInput = scanner.nextLine();
        System.out.println("All lower case " + userInput.toLowerCase());

    switch(userInput.toLowerCase()){
        case "capricorn":
            System.out.println("Capricorn's the moneymakers!");
        break;
        case "aquarius":
            System.out.println("You are the water bearer!");
        break;
        case "pisces":
            System.out.println("You're the fish");
        break;
        default:
            System.out.println("Sorry that is not a sign");
        break;
        }


    }
}