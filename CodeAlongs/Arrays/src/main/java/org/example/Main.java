package org.example;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        int[] numbers2 = new int[10];
        int[] numbers3 = new int[2];

        System.out.println("Numbers length is: " + numbers.length);
        System.out.println("Numbers2 length is: " + numbers2.length);
        System.out.println("Numbers3 length is: " + numbers3.length);

        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        //out of bounds/range
        //numbers[5] = 60;

        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }
}