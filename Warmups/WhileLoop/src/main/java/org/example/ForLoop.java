package org.example;

import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
            if (i == 1){
                System.out.println("LAUNCH!");
            }
        }
    }
}
