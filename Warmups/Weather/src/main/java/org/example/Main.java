package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How's the weather today? (Sunny, Cloudy, Rainy): ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("sunny")) {
            System.out.println("It's a great day for outdoor activities!");
        } else if (input.equalsIgnoreCase("cloudy")) {
            System.out.println("The weather is a bit uncertain.");
        } else if(input.equalsIgnoreCase("rainy")) {
            System.out.println("Sorry, I'm not sure about that weather type.");
        }


    }
}