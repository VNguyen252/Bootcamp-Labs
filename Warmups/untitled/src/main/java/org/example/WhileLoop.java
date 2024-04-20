package org.example;

import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) throws InterruptedException {
        int whileLoop = 1;

        while (whileLoop < 20){
            System.out.println(whileLoop);
            Thread.sleep(1000);
            whileLoop++;
        }
    }
}
