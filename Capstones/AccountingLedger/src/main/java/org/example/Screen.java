package org.example;

import java.util.*;

public class Screen {

    public static String selection() {

        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public static void homeScreen() {
        while (true) {

            System.out.println("""
                    Empty ya pockets
                    D) Add Deposit
                    P) Make Debit Payment
                    L) View Ledger
                    X) Exit (Coward)
                    """);

            switch (selection().toLowerCase()) {
                case "d" -> addDeposit();
                case "p" -> addPayment();
                case "l" -> ledgerScreen();
                case "x" -> {System.exit(0);
                }
                default -> {
                    System.out.println("Ya done messed up");
                    System.out.println("Select the letter options listed!");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private static void addDeposit() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("--Depositing--");

                Transaction deposit = new Transaction();

                System.out.println("Description:");
                String description = scanner.nextLine();

                System.out.println("Vendor:");
                String vendor = scanner.nextLine();

                System.out.println("Amount:");
                double amount = Double.parseDouble(scanner.nextLine());

                deposit.setDescription(description);
                deposit.setVendor(vendor);
                deposit.setAmount(amount);
                FileReadWrite.writeTransaction(deposit);
            }
            catch (NumberFormatException ex) {
                System.out.println("Goofball.");

                try {Thread.sleep(2000);}
                catch (InterruptedException e) {throw new RuntimeException(e);}
            }
            homeScreen();
        }

    }

    private static void addPayment() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("--Making Payment--");

                Transaction payment = new Transaction();

                System.out.println("Description:");
                String description = scanner.nextLine();

                System.out.println("Vendor:");
                String vendor = scanner.nextLine();

                System.out.println("Amount:");
                double amount = Math.abs(Double.parseDouble(scanner.nextLine())) * -1;

                payment.setDescription(description);
                payment.setVendor(vendor);
                payment.setAmount(amount);
                FileReadWrite.writeTransaction(payment);
            }
            catch (NumberFormatException ex) {
                System.out.println("Goofball.");

                try {Thread.sleep(2000);}
                catch (InterruptedException e) {throw new RuntimeException(e);}
            }
            homeScreen();
        }
    }

    private static void ledgerScreen() {

        System.out.println("--Ledger--");

        while (true) {
            System.out.println("""
                    A) All the Transactions
                    D) All the Deposits
                    P) All the Payments
                    R) Filtered Reports
                    H) Return to Home screen
                    """);

            switch (selection().toLowerCase()) {
                case "a" -> {
                    List<Transaction> allTransactions = SortSearch.getAllTransactions(FileReadWrite.readTransaction());
                    transactionPrint(allTransactions);
                }
                case "d" -> {
                    List<Transaction> deposits = SortSearch.getAllDeposits(FileReadWrite.readTransaction());
                    transactionPrint(deposits);
                }
                case "p" -> {
                    List<Transaction> withdraw = SortSearch.getAllPayments(FileReadWrite.readTransaction());
                    transactionPrint(withdraw);
                }
                case "r" -> sortSelection();
                case "h" -> homeScreen();
                default -> {
                    System.out.println("You goofed");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }

    public static void sortSelection() {

        System.out.println("Alrighty lets see...");

        while (true) {
            System.out.println("""
                    1) Month To Date
                    2) Last Month
                    3) Year To Date
                    4) Last Year
                    5) Search by Vendor
                    6) Custom Search
                    0) Back to Ledger Screen
                    """);

            switch (selection()) {
                case "1" -> {
                    List<Transaction> monthToDate = SortSearch.transactionsByPeriod(FileReadWrite.readTransaction(), "MonthToDate");
                    transactionPrint(monthToDate);
                }
                case "2" -> {
                    List<Transaction> previousMonth = SortSearch.transactionsByPeriod(FileReadWrite.readTransaction(), "PreviousMonth");
                    transactionPrint(previousMonth);
                }
                case "3" -> {
                    List<Transaction> yearToDate = SortSearch.transactionsByPeriod(FileReadWrite.readTransaction(), "YearToDate");
                    transactionPrint(yearToDate);
                }
                case "4" -> {
                    List<Transaction> previousYear = SortSearch.transactionsByPeriod(FileReadWrite.readTransaction(), "PreviousYear");
                    transactionPrint(previousYear);
                }
                case "5" -> {
                    List<Transaction> vendorSort = SortSearch.searchByVendor(FileReadWrite.readTransaction());
                    transactionPrint(vendorSort);
                }
                case "6" -> customSift();
                case "0" -> ledgerScreen();
                default -> {
                    System.out.println("You goofball. Try again.");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void transactionPrint(List<Transaction> transactions) {

        int transactionCount = 0;

        for (Transaction transaction : transactions) {
            System.out.printf("Date: %s Time: %s Description: %s Vendor: %s Amount: %s\n",
                    transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());

            transactionCount++;
        }
        if (transactionCount == 0) {
            System.out.println("WHAT ARE YOU AIMING AT?");

            try {Thread.sleep(2000);}
            catch (InterruptedException e) {throw new RuntimeException(e);}
        }
        else {
            System.out.println("That is all I could find.");
        }
    }

    public static void customSift() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Leave it blank and press enter if you can't remember.");
        System.out.println("How early am I checking for? (yyyy-mm-dd)");
        String startDate = scanner.nextLine();

        if(startDate.isEmpty()){
            startDate = null;
        }

        System.out.println("What about the latest? (yyyy-mm-dd)");
        String endDate = scanner.nextLine();

        if(endDate.isEmpty()){
            endDate = null;
        }

        System.out.println("Description of payment:");
        String description = scanner.nextLine();

        System.out.println("Vendor?");
        String vendor = scanner.nextLine();

        System.out.println("Highest Value:");
        String maxAmountInput = scanner.nextLine();

        System.out.println("Lowest Value:");
        String minAmountInput = scanner.nextLine();

        Double minAmount = null;
        Double maxAmount = null;

        try {
            if (!minAmountInput.isEmpty() && !maxAmountInput.isEmpty()) {
                minAmount = Double.parseDouble(minAmountInput);
                maxAmount = Double.parseDouble(maxAmountInput);
            }
        }
        catch (NumberFormatException ex){
            System.out.println("WHAT ARE YOU AIMING AT?");

            try {Thread.sleep(2000);}
            catch (InterruptedException e) {throw new RuntimeException(e);}
        }
        transactionPrint(CustomSearch.customSearch(FileReadWrite.readTransaction(),
                startDate, endDate, description, vendor, minAmount, maxAmount));
    }
}