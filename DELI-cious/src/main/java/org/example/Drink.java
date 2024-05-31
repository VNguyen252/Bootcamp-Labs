package org.example;

public abstract class Drink extends Product {
    private String size;
    private String flavor;
    public Drink(double price, String description, String size, String flavor) {
        super(description, price);
        this.size = size;
        this.flavor = flavor;
    }
    public String getSize() {
        return size;
    }
    public String getFlavor() {
        return flavor;
    }
}