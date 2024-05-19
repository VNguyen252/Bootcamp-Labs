package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String favoriteColor = "Blue";

        System.out.println("What do you think is my favorite color?");

        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();

        //conditional
        if(result.equalsIgnoreCase("Blue")){
            System.out.println("Yes, blue is my favorite color!");
        }
        else{
            System.out.println("Sorry, better luck net time.");
        }
    }
}