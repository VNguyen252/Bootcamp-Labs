package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        for(int i = 20; i > 0; i--){
            System.out.println(i);
            Thread.sleep(1000);
        }
    }
}