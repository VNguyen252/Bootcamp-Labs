package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Cats trisha = new Cats("orange", "crazy cat", 4);


        System.out.println("Trisha's color was: " + trisha.getFurColor());

        trisha.setFurColor("black");

        System.out.println("Trisha's fur color is now: " + trisha.getFurColor());

    }
}