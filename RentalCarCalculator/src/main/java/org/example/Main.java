package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       String pickupDate;
       int rentedDays;
       boolean eTag;
       boolean GPS;
       boolean roadSide;
       int age;

        System.out.println("Basic Car rental starts at $29.99/day");
        System.out.println("When would you like to pick up the car? (MM/DD/YY)");
        pickupDate = input.nextLine();
        System.out.println("How many days would you like to rent?");
        rentedDays = input.nextInt();
        System.out.println("Do you want an Electronic Toll Tag? ($3.95/day) (Y/N)");
        eTag = input.next().equalsIgnoreCase("y");
        System.out.println("Do you want GPS? ($2.95/day) (Y/N)");
        GPS = input.next().equalsIgnoreCase("y");
        System.out.println("Do you want roadside assistance? (Y/N) (3.95)");
        roadSide = input.next().equalsIgnoreCase("y");
        System.out.println("How old are you?");
        age = input.nextInt();


        double basicRental = 29.99 * rentedDays;

        double addOns = 0.0;
        if (eTag) addOns += 3.95 * rentedDays;
        if (GPS) addOns += 2.95 * rentedDays;
        if (roadSide) addOns += 3.95 * rentedDays;

        double surcharge = age < 25
                ? basicRental *1.3
                : 0.0;
        double total = basicRental + addOns + surcharge;

        System.out.println("""
                
                Pickup 
                
                """);





    }
}