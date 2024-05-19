package org.example;

public class Main {
    public static void main(String[] args) {
        book book = new book("Fahrenheit 451", "Ray Bradbury", 300);

        //use the overloaded constructor
        book book2 = new book("Foundation and Earth", "Isaac Asimov");

        book book3 = new book("Martian Chronicles");
    }
}