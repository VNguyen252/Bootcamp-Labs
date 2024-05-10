package org.example;

import java.util.*;

public class CustomSearch {
    public static List<Transaction> customSearch(List<Transaction> transactions, String startDate, String endDate, String description, String vendor, Double minAmount, Double maxAmount) {
        List<Transaction> customSearch = new ArrayList<>();

        for (Transaction transaction : transactions) {
            double amount = transaction.getAmount();
            boolean matches = startDate == null || transaction.getDate().compareTo(startDate) >= 0;

            if (endDate != null && transaction.getDate().compareTo(endDate) > 0) {
                matches = false;
            }

            if (description != null && !transaction.getDescription().toLowerCase().contains(description.toLowerCase())) {
                matches = false;
            }

            if (vendor != null && !transaction.getVendor().toLowerCase().contains(vendor.toLowerCase())) {
                matches = false;
            }

            if (minAmount != null && maxAmount != null) {
                if ((minAmount <= 0 && maxAmount >= 0) || (minAmount >= 0 && maxAmount <= 0)) {
                    if (!(amount >= minAmount && amount <= maxAmount)) {
                        matches = false;
                    }
                }
                else if (minAmount >= 0 && maxAmount >= 0) {
                    if (!(amount >= minAmount && amount <= maxAmount)) {
                        matches = false;
                    }
                }
                else if (minAmount <= 0 && maxAmount <= 0) {
                    if (!(amount >= minAmount && amount <= maxAmount)) {
                        matches = false;
                    }
                }
            }
            if (matches) {
                customSearch.add(transaction);
            }
        }
        return customSearch;
    }
}