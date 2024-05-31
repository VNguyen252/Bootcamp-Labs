package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public interface Screen {
    boolean display();
}
class HomeScreen implements Screen {
    private final OrderManager orderManager;
    private final Scanner scanner;

    public HomeScreen(OrderManager orderManager, Scanner scanner) {
        this.orderManager = orderManager;
        this.scanner = scanner;
    }
    @Override
    public boolean display() {
        System.out.println("\nWelcome to DELI-cious!");
        System.out.println("1) New Order");
        System.out.println("0) Exit");

        System.out.print("Please select an option: ");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                orderManager.startNewOrder();
                OrderScreen orderScreen = new OrderScreen(orderManager, scanner);
                orderScreen.display();
                break;
            case "0":
                System.out.println("Exiting...");
                return false;

            default:
                System.out.println("Invalid option, please try again.");
                break;
        }
        return true;
    }
}
class OrderScreen implements Screen {
    private final OrderManager orderManager;
    private final Scanner scanner;
    public OrderScreen(OrderManager orderManager, Scanner scanner) {
        this.orderManager = orderManager;
        this.scanner = scanner;
    }
    @Override
    public boolean display() {
        boolean ordering = true;
        while (ordering) {
            System.out.println("--------------------------------------------------");
            System.out.println("\nOrder Menu:");
            System.out.println("1) Make a monstrosity");
            System.out.println("2) Some refreshments?");
            System.out.println("3) Care for some crisps?");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("--------------------------------------------------");
            System.out.print("Quit lollygagging and PICK ONE: ");
            String input = scanner.nextLine();
            System.out.println("\n--------------------------------------------------");
            switch (input) {
                case "1":
                    AddItemScreen addItemScreenSandwich = new AddItemScreen(orderManager, "1",scanner);
                    addItemScreenSandwich.display();
                    break;
                case "2":
                    AddItemScreen addItemScreenDrink= new AddItemScreen(orderManager, "2", scanner);
                    addItemScreenDrink.display();
                    break;
                case "3":
                    AddItemScreen addItemScreenChips = new AddItemScreen(orderManager,"3", scanner);
                    addItemScreenChips.display();
                    break;
                case "4":
                    orderManager.finalizeOrder();
                    ordering = false;
                    break;
                case "0":
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
        scanner.close();
        return ordering;
    }
}
class AddItemScreen implements Screen {
    private final OrderManager orderManager;
    private final String itemType;
    private final Scanner scanner;

    public AddItemScreen(OrderManager orderManager, String itemType, Scanner scanner) {
        this.orderManager = orderManager;
        this.itemType = itemType;
        this.scanner = scanner;
    }
    @Override
    public boolean display() {
        System.out.println("Adding Item to Order: " + itemType);
        switch (itemType) {
            case "1": // Add Sandwich
                System.out.println("--------------------------------------------------");
                System.out.println("What kind of monstrosity sandwich do you want to make?");
                // Gather sandwich details from user
                Sandwich sandwich = createSandwich(scanner);
                orderManager.addItemToOrder(sandwich);
                break;
            case "2": // Add Drink
                System.out.println("--------------------------------------------------");
                System.out.println("Enter details for the Drink...");
                // Gather drink details from user
                Drink drink = createDrink(scanner);
                orderManager.addItemToOrder(drink);
                break;
            case "3": // Add Chips
                System.out.println("--------------------------------------------------");
                System.out.println("Enter details for the Chips...");
                // Gather chips details from user
                Chips chips = createChips(scanner);
                orderManager.addItemToOrder(chips);
                break;
            default:
                System.out.println("--------------------------------------------------");
                System.out.println("What are you talking about, you goober?");
                break;
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Item added to order.");
        return false;
    }
    private Sandwich createSandwich(Scanner scanner) {
        System.out.println("Let's see...");
        System.out.println("Choose sandwich size (4\", 8\", 12\"): ");
        String size = scanner.nextLine();
        Sandwich sandwich = new Sandwich(size);
        System.out.println("What bread are we working with? (sourdough, white, wheat, rye, wrap): ");
        String breadType = scanner.nextLine();
        sandwich.setBreadType(breadType);
        System.out.println("Pick a meat (pastrami, steak, ham, salami, roast beef, chicken, bacon): ");
        String meat = scanner.nextLine();
        sandwich.setMeat(meat);
        System.out.println("Want more meat? (yes/no): ");
        boolean extraMeat = scanner.nextLine().trim().equalsIgnoreCase("yes");
        sandwich.setExtraMeat(extraMeat);
        System.out.println("Choose ya cheese (pepperjack, american, provolone, cheddar, swiss): ");
        String cheese = scanner.nextLine();
        sandwich.setCheese(cheese);
        System.out.println("Want any extra? (yes/no): ");
        boolean extraCheese = scanner.nextLine().trim().equalsIgnoreCase("yes");
        sandwich.setExtraCheese(extraCheese);
        String[] availableToppings = {"spinach", "lettuce", "onions", "pickled peppers", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole"};
        System.out.println("Available toppings: ");
        for (String topping : availableToppings) {
            System.out.println("- " + topping);
        }
        System.out.println("Pick yours toppings, buddy. (type 'done' to finish): ");
        String toppingInput;
        while (!(toppingInput = scanner.nextLine()).equalsIgnoreCase("done")) {
            if (Arrays.asList(availableToppings).contains(toppingInput.toLowerCase())) {
                Topping topping = new Topping(toppingInput, size);
                sandwich.addRegularTopping(topping);
                System.out.println("Add another topping or type 'done':");
            } else {
                System.out.println("You put that on a sandwich? Gross, pick something else.");
            }
        }
        String[] availableSauces = {"mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette"};
        System.out.println("Available sauces: ");
        for (String sauces : availableSauces) {
            System.out.println("- " + sauces);
        }
        System.out.println("Pick your toppings, buddy. (type 'done' to finish): ");
        String sauceInput;
        while (!(sauceInput = scanner.nextLine()).equalsIgnoreCase("done")) {
            if (Arrays.asList(availableSauces).contains(sauceInput.toLowerCase())) {
                Topping sauces = new Topping(sauceInput, size);
                sandwich.addRegularTopping(sauces);
                System.out.println("Add another sauces or type 'done':");
            } else {
                System.out.println("You put that on a sandwich? Gross, pick something else.");
            }
        }
        return sandwich;
    }
    private Drink createDrink(Scanner scanner) {
        System.out.println("Pick your poison (Moonshine, Sprite, A&W, Cola, Lemon, Orange):");
        String flavor = scanner.nextLine();
        System.out.println("How thirsty are ya? (Small, Medium, Large):");
        String size = scanner.nextLine();
        double price = size.equalsIgnoreCase("Small") ? 2.00 : size.equalsIgnoreCase("Medium") ? 2.50 : 3.00;
        return new Drink(price, flavor + " " + size, size, flavor) {
            @Override
            public String getDescription() {
                return "";
            }
        };
    }
    private Chips createChips(Scanner scanner) {
        System.out.println("What kind of chips do you want? (Salted, Unsalted, Jalapeno, Ghost Pepper, BBQ, Salt & Vinegar):");
        String type = scanner.nextLine();
        double price = 1.50;
        return new Chips(price, type + " Chips", type) {
            @Override
            public String getDescription() {
                return "";
            }
        };
    }
}