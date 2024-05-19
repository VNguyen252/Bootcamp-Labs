package org.example;

public class book {
    private String title;
    private String author;
    private int pages;

    public book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    //overload the constructor
    public book(String title, String author){
        this.title = title;
        this.author = author;
        this.pages = 0;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public book(String title){
        this.title = title;
        this.author = null;
        this.pages = 0;
    }

    public String getTitle(){
        return title;
    }

    //method signature public/private what it returns, the name, and parameters
    public void displayInfo(){
        System.out.println("Book: " + this.getTitle() + " Author: " + this.getAuthor());
    }

    public void displayInfo(String prefix){
        System.out.println("Book: " + this.getTitle() + " Author: " + this.getAuthor());
    }
}
