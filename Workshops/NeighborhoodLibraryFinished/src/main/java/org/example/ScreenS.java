package org.example;

import java.util.Scanner;

public class ScreenS {
    private Books bookInventory = new Books();
    public void storeHomeScreen() {
        Scanner scanner = new Scanner(System.in);
        Book[] books = bookInventory.inventory();
        while (true) {
            System.out.println("\nWhat's kickin' want some chicken?");
            System.out.println("And by chicken I mean books. Obviously.");
            System.out.println("\n1. See what we have.");
            System.out.println("2. Snooze you lose, bozo.");
            System.out.println("3. Buzz off");
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    showAvailable(books);
                    break;
                case 2:
                    showCheckedOut(books);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\nMaybe try making some sense?");
            }
        }
    }
    public void showAvailable(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nLucked out, we have the scrolls");
        System.out.println("\nHURRY UP PICK ONE");
        boolean availableBooksExist = false;
        for (Book book : books) {
            if (book.isCheckOut() == false) {
                System.out.println(book.getId() + " - " + book.getIsbn() + " - " + book.getTitle());
                availableBooksExist = true;
            }
        }
        if (availableBooksExist == false) {
            System.out.println("Everyone point & laugh. No scrolls for this guy.");
            return;
        }
        while (true) {
            System.out.println("Hurry & pick a scroll (ID), or press 0 to run away:");
            int userInput = scanner.nextInt();
            if (userInput == 0) {
                return;
            } else if (userInput > 0 && userInput <= books.length) {
                int selectedIndex = userInput - 1;
                checkingOut(books[selectedIndex]);
                return;
            } else {
                System.out.println("You goofed. Start over.");
            }
        }
    }
    public void checkingOut(Book book) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Doing some building, eh?");
        System.out.println("\n Let's wrap this up.");
        System.out.println("\n Give me your firstborn(type: firstborn) or type your first name:");
        String checkingName = scanner.nextLine();
        if (checkingName.equalsIgnoreCase("firstborn")) {
            System.out.println("\nThat's f***ed up, man. Go in the corner.");
            return;
        }
        if (checkingName.equalsIgnoreCase("0")) {
            return;
        }
        if (!book.isCheckOut()) {
            book.setCheckOut(true);
            book.setCheckOutTo(checkingName);
            System.out.println("\nReturn this scroll if you value your knees.");
            System.out.println("Scroll: " + book.getTitle());
            System.out.println("Target Name: " + checkingName);
        } else {
            System.out.println("Snooze you lose, bozo. Get something else.");
        }
    }
    public void showCheckedOut(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nReturnin a scroll? Very smart of you.");
        System.out.println("\nWhat're you returning?");
        boolean checkedOutBooksExist = false;
        System.out.println("\nMissing scrolls. Targets marked:");
        for (Book book : books) {
            if (book.isCheckOut()) {
                System.out.println(book.getId()+" - "+book.getIsbn()+" - "+book.getTitle()+" (Checked out by: "+book.getCheckOutTo()+")");
                checkedOutBooksExist = true;
            }
        }
        if (!checkedOutBooksExist) {
            System.out.println("We have all our scrolls. Go ahead & check them out.");
            return;
        }
        System.out.println("\nWhat scroll(ID) are you returning? press 0 to run away:");
        int userInput = scanner.nextInt();
        if (userInput == 0) {
            return;
        } else if (userInput > 0 && userInput <= books.length) {
            int selectedIndex = userInput - 1;
            Book selectedBook = books[selectedIndex];
            if (selectedBook.isCheckOut()) {
                selectedBook.setCheckOut(false);
                selectedBook.setCheckOutTo(null);
                System.out.println("You returned '" + selectedBook.getTitle() + "'. Your knees are safe. For now.");
            } else {
                System.out.println("We have this scroll already you goof.");
            }
        } else {
            System.out.println("What are you even saying? NEXT!!!!");
        }
    }
}