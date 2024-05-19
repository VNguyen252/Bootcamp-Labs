package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;
    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Transaction(String date, String time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public Transaction() {
        this.date = LocalDate.now().format(df);
        this.time = LocalTime.now().format(tf);
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public void currentDate(){
        this.date = LocalDate.now().format(df);
    }

    public void currentTime(){
        this.time = LocalTime.now().format(tf);
    }

}