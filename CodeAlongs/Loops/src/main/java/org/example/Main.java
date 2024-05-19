package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //while loops
        int dormamuHasHadEnough = 0;

        while(dormamuHasHadEnough < 10){
            System.out.println("Dormamu I've come to bargain.");
            System.out.println("Dormamu brutally destroys Dr. Strange.");
            dormamuHasHadEnough++; //fancy way of adding one to the variable
        }



        //little trick you can do
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("This will run forever.");
            System.out.println("Do you want to stop?");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("yes")){
                System.out.println("The earth is saved!");
                System.out.println("Exiting while loop");
                break;
            }
        }

        //for loops
        //when you have an idea of how many times you want to do something
        for(int i = 0; i < 10; i++){
            System.out.println("For loop, i is: " + i);
        }

        for(int potato = 0; potato < 10; potato++){
            System.out.println("For loop, potato is: " + potato);
        }
    }
}