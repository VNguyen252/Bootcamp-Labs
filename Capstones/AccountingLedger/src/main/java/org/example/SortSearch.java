package org.example;

import java.util.*;
import java.time.*;

public class SortSearch {

    public static List<Transaction> getAllTransactions(List<Transaction> transactions) {
        List<Transaction> allTransactions = new ArrayList<>();

        transactions.sort(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                int dateComparison = t2.getDate().compareTo(t1.getDate());

                if (dateComparison != 0) {
                    return dateComparison;
                }

                return t2.getTime().compareTo(t1.getTime());
            }
        });

        for (Transaction transaction : transactions) {
            System.out.printf("%s %s %s %s %s\n",
                    transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());

            allTransactions.add(transaction);
        }
        return allTransactions;
    }

    public static List<Transaction> getAllDeposits(List<Transaction> transactions) {
        List<Transaction> deposits = new ArrayList<>();

        transactions.sort(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                int dateComparison = t2.getDate().compareTo(t1.getDate());

                if (dateComparison != 0) {
                    return dateComparison;
                }

                return t2.getTime().compareTo(t1.getTime());
            }
        });

        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > 0) {
                deposits.add(transaction);
            }
        }
        return deposits;
    }

    public static List<Transaction> getAllPayments(List<Transaction> transactions) {
        List<Transaction> withdraw = new ArrayList<>();

        transactions.sort(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                int dateComparison = t2.getDate().compareTo(t1.getDate());

                if (dateComparison != 0) {
                    return dateComparison;
                }

                return t2.getTime().compareTo(t1.getTime());
            }
        });
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                withdraw.add(transaction);
            }
        }
        return withdraw;
    }

    public static List<Transaction> transactionsByPeriod(List<Transaction> transactions, String period) {
        LocalDate currentDate = LocalDate.now();

        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
        LocalDate firstOfLastMonth = firstDayOfMonth.minusMonths(1);
        LocalDate lastOfLastMonth = firstDayOfMonth.minusDays(1);

        LocalDate firstOfYear = currentDate.withDayOfYear(1);
        LocalDate firstOfLastYear = firstOfYear.minusYears(1);
        LocalDate lastOfLastYear = firstOfYear.minusDays(1);

        return switch (period) {
            case "MonthToDate" -> filterTransactions(transactions, firstDayOfMonth, currentDate);
            case "PreviousMonth" -> filterTransactions(transactions, firstOfLastMonth, lastOfLastMonth);
            case "YearToDate" -> filterTransactions(transactions, firstOfYear, currentDate);
            case "PreviousYear" -> filterTransactions(transactions, firstOfLastYear, lastOfLastYear);
            default -> throw new IllegalArgumentException("Invalid");
        };
    }

    private static List<Transaction> filterTransactions(List<Transaction> transactions, LocalDate startDate, LocalDate endDate) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());

            if (!transactionDate.isBefore(startDate) && !transactionDate.isAfter(endDate)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public static List<Transaction> searchByVendor(List<Transaction> transactions) {
        List<Transaction> vendorSort = new ArrayList<>();

        int transactioncount = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Tell me the name and I'll see what I can do.");
        String vendorName = scanner.nextLine();

        for (Transaction transaction : transactions) {
            if (transaction.getVendor().equalsIgnoreCase(vendorName)) {
                vendorSort.add(transaction);
                transactioncount++;
            }
        }
        if (transactioncount == 0) {
            System.out.println("WHAT ARE YOU EVEN AIMING AT?");
        }
        return vendorSort;
    }


}