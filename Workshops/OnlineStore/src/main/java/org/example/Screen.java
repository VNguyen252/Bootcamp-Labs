package org.example;

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Screen {
    public void storeHomeScreen() {
        Scanner scanner = new Scanner(System.in);
        List<Goods> goods = new ArrayList<>();
        System.out.println("");
        while (true){
            System.out.println("""
                                  Howdy dee neighbor!!!
                                  Watcha wanna do?
                                  1) See all our fine merchandise!!
                                  2) Show the goods in your cart!!
                                  3) Later gator!""");
            boolean launched = true;
            while (launched){
                System.out.println("Make a decision, bucko. You're wastin' my time.");
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);
                switch(choice){
                    case 1: launched = false;
                        displayGoods(goods, scanner);
                        break;
                    case 2: launched = false;
                        displayCart(goods, scanner);
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Quit lollygaggin', BACK OF THE LINE!");
                }
            }
        }
    }
    public void displayGoods(List<Goods> goods, Scanner scanner) {
        String filePath = "src/main/resources/";
        String goodsFile = filePath + "products.csv";
        String shoppingCart = filePath + "cartofGoods.csv";
        System.out.println("Look over yonder");
        try(BufferedReader reader = new BufferedReader(new FileReader(goodsFile))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split("\\|");
                String sku = data[0];
                String goodsName = data[1];
                double price = Double.parseDouble(data[2]);
                String department = data[3];

                Goods good = new Goods(sku, goodsName, price, department);
                goods.add(good);
            }
        }
        catch (IOException ex){
            System.out.println("File not found");
        }
        for (Goods product : goods){
            System.out.println("SKU: " + product.getSku() + " Name: "
                    + product.getGoodsName() + " Price: " + product.getPrice() + " Department: " + product.getDepartment());
        }
        System.out.println("""
                Ya lookin' for anythang in specific?
                1) Yessir'
                2) Nope""");
        while (true) {
            System.out.print("Enter your choice here: ");
            String userSearchFilter = scanner.nextLine();
            if (userSearchFilter.equalsIgnoreCase("1") || userSearchFilter.equalsIgnoreCase("Yessir")) {
                searchFilter(goods, userSearchFilter, scanner);
                break;
            } else if (userSearchFilter.equalsIgnoreCase("3") || userSearchFilter.equalsIgnoreCase("Nope")) {
                System.out.println("Nope");
                break;
            } else {
                System.out.println("Quit lollygaggin', BACK OF THE LINE!");
            }
        }
        System.out.println("HURRY. There's a line.");
        while(true){
            System.out.println("Add your products then GET!(type 'ready' when done)");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("ready")) {
                break;
            } else {
                for (Goods product : goods) {
                    if (userInput.equalsIgnoreCase(product.getGoodsName())) {
                        try {
                            FileWriter writer = new FileWriter(shoppingCart, true);
                            writer.write(product.getSku() + "|" + product.getGoodsName() + "|" + product.getPrice() + "|" + product.getDepartment() + "\n");
                            writer.close();
                        } catch (IOException ex) {
                            System.out.println("Do something RIGHT.");
                        }
                    }
                }
            }
        }
    }
    public void searchFilter(List<Goods> products,String userInput, Scanner scanner){
        List<Goods> goods = new ArrayList<>();
        String filePath = "src/main/resources/";
        String goodsFile = filePath + "products.csv";
        String shoppingCart = filePath + "shopping_cart.csv";

        while (userInput.equalsIgnoreCase("1") || userInput.equalsIgnoreCase("Yessir")) {
            System.out.println("Tell me what ya want. HURRY. THERE'S A LINE!");
            try(BufferedReader reader = new BufferedReader(new FileReader(goodsFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split("\\|");
                    String sku = data[0];
                    String goodsName = data[1];
                    double price = Double.parseDouble(data[2]);
                    String department = data[3];

                    Goods good = new Goods(sku, goodsName, price, department);
                    goods.add(good);
                    for (Goods product : goods) {
                        if (userInput.equalsIgnoreCase(product.getGoodsName())) {
                            try {
                                FileWriter writer = new FileWriter(shoppingCart, true);
                                writer.write(product.getSku() + "|" + product.getGoodsName() + "|" + product.getPrice() + "|" + product.getDepartment() + "\n");
                                writer.close();
                            } catch (IOException ex) {
                                System.out.println("Do something RIGHT.");
                            }
                        }
                    }
                }
            } catch (IOException ex) {
                System.out.println("Do something RIGHT.");
            }
        }
    }
    public void displayCart(List<Goods> goods, Scanner scanner) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String filePath = "src/main/resources/";
        String shoppingCart = filePath + "cartofgoods.csv";
        double sum = 0;
        System.out.println("Here's your cart of goods.");
        goods.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(shoppingCart))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cartDisplay = line.split("\\|");
                String sku = cartDisplay[0];
                String productName = cartDisplay[1];
                double price = Double.parseDouble(cartDisplay[2]);
                String department = cartDisplay[3];
                Goods product = new Goods(sku, productName, price, department);
                goods.add(product);
            }
        } catch (IOException ex) {
            System.out.println("Do something RIGHT.");
        }
        for (Goods product : goods) {
            System.out.println("SKU: " + product.getSku() + " Name: "
                    + product.getGoodsName() + " Price: " + product.getPrice() + " Department: " + product.getDepartment());
            sum += product.getPrice();
        }
        System.out.println("Total: $" + decimalFormat.format(sum));
        System.out.println("Your pockets look light ,pal. You sure you wanna buy all this?(Yes/No)");
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("No")) {
            System.out.println("I knew you were too broke. Watcha backin' out on?");
            String userReturn = scanner.nextLine();
            List<Goods> updatedGoods = new ArrayList<>();
            for (Goods product : goods) {
                if (!userReturn.equalsIgnoreCase(product.getSku())) {
                    updatedGoods.add(product);
                } else {
                    sum -= product.getPrice();
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(shoppingCart))) {
                for (Goods product : updatedGoods) {
                    writer.write(product.getSku() + "|" + product.getGoodsName() + "|" + product.getPrice() + "|" + product.getDepartment());
                    writer.newLine();
                }
                System.out.println("Alright, quitcher yappin', I took " + userReturn + " off your tab.");
            } catch (IOException ex) {
                System.out.println("DO SOMETHING RIGHT!!!");
            }
        }
        checkOut(goods, scanner, sum);
    }
    public void checkOut(List<Goods> goods, Scanner scanner, double sum){
        String filePath = "src/main/resources/";
        String shoppingCart = filePath + "cartofGoods_cart.csv";
        System.out.println("\nTotal: $" + (sum));
        System.out.println("Ready to cough over them coins?(Yes/No");
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("Yes")){
            System.out.println("Alrighty now we're talking. How much?");
        } else if (userInput.equalsIgnoreCase("No")) {
            System.out.println("Unfortunately for you, we have a 'Touch it, you buy it' policy.");
        }else {
            System.out.println("Quit that gibberish. Cough over the coin.");
        }
        System.out.println("How much coin you coughin over.");
        String userCash = scanner.nextLine();
        double cash = Double.parseDouble(userCash);
        while (true){
            if (cash >= sum){
                System.out.println("Thanks for the $" + (cash - sum) + " tip bucko.");
                break;
            } else if (cash < sum) {
                System.out.println("HOLD IT. You still owe $" + (sum - cash));
                System.out.println("You wanna pay more coins or pay with your knees?");
                String userExtraPay = scanner.nextLine();
                cash += Double.parseDouble(userExtraPay);
                System. exit(0);
            }
        }
    }
}