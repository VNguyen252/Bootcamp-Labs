package org.example;

public class Calculator {
    public double add(double a, double b){
        return a + b;
    }

    public double subtract(double a, double b){
        return a - b;
    }

    public double divide(double a, double b){
        if(b == 0){
            throw new IllegalArgumentException("Cannot by zero");
        }
        return a / b;
    }
}