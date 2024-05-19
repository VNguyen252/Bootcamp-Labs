package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //instantiate the Scanner
        Scanner scanner = new Scanner(System.in);

        Dog fido = new Dog("black", "german shepherd", 2, 3.5);
        Dog bandit = new Dog("black", "yorkie", 2, 1);

        fido.bark();
        bandit.bark();

        System.out.println(fido.getFurColor());

        fido.setFurColor("gold");

        System.out.println("Fido's fur color is now: " + fido.getFurColor());

        BankAccount newAccount = new BankAccount(100, "Jonathon");

        newAccount.deposit(150);
        newAccount.withdraw(50);

        newAccount.balance = 1000;

        System.out.println(newAccount.balance);

    }
}