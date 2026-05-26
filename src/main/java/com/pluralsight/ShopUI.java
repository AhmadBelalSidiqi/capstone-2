package com.pluralsight;

import com.pluralsight.enums.*;

import java.util.Scanner;

public class ShopUI {
    Order order;
    static Scanner scanner = new Scanner(System.in);
    public void mainMenu() {
        String menu = """
                ----------------------------------------
                Hello Welcome To Deli-cious Sandwich Shop
                Please choose one of the following:
                1) New Order
                0) Exit
                ---------------------------------------""";
        boolean running = true;
        do {
            System.out.println(menu);
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("1"))
                orderScreen();
            else
                running = false;

        } while (running);

        System.out.println("Thank you Have a good day!");
    }

    private void orderScreen() {
         this.order = new Order();
        String menu = """
                Please choose one of the following:
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) Checkout
                0) Cancel Order
                --------------------------------------""";
        boolean running = true;
        do {
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1" :
                    addSandwich();
                    break;
                case "2" :
                    addDrink();
                    break;
                case "3" :
                    addChip();
                    break;
                case "4" :
                    checkout();
                    running = false;
                    break;
                case "0" :
                    cancelOrder();
                    running = false;
                    break;
            }

        }while (running);

    }

    private void addSandwich() {
        String menu = """
                Please Choose one of the following options
                1) Make your own sandwich
                2) BLT Sandwich
                3) Philly Cheese Steak
                -----------------------""";
        do {
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput){
                case "1" :
                    this.order.addProduct(getUserSandwich());
                    return;
                case "2" :
                    this.order.addProduct(signatureBLTSandwich());
                    return;
                case "3" :
                    this.order.addProduct(signaturePhillyCheeseSteakSandwich());
                    return;
                default :
                    System.out.println("Please select correct option.");

            }
        }while(true);

    }

    private void addChip() {
        order.addProduct(new Chip());
    }

    private void addDrink() {
        String menu = """
                Please choose one of following size:
                1) Large
                2) Medium
                3) Small
                ------------------------------------""";
        System.out.println(menu);
        String userInput = scanner.nextLine();
        switch (userInput){
            case "1" :
                this.order.addProduct(new Drink(Size.LARGE));
                break;
            case "2" :
                this.order.addProduct(new Drink(Size.MEDIUM));
                break;
            case "3" :
                this.order.addProduct(new Drink((Size.SMALL)));
                break;
            default :
                System.out.println("No Drinks added");
        }
    }

    private void checkout() {
        if (this.order.isOrderEmpty())
            enforceAPurchase();
        System.out.println("----------Order---------");
        displayOrder();
        System.out.println("--------------------------");
        System.out.println("Please confirm if the order is correct (Yes/No)");
        if((scanner.nextLine()).equalsIgnoreCase("yes")){
            ReceiptFileManager.saveReceipt(this.order);
            System.out.println("Your checkout is successful");
            order.clearOrder();
            return;
        }
        order.clearOrder();
        System.out.println("Order Canceled.");
    }

    private void cancelOrder() {
        this.order.clearOrder();
    }

    private void displayOrder() {
        System.out.println(this.order.showOrder());
    }

    private void enforceAPurchase() {
        String menu = """
                You order is empty,
                To complete your checkout,
                you have to buy one of the followings items
                1) Add Drink
                2) Add Chip
                ----------------------------------""";
        do{
            System.out.println(menu);
            String userInput = scanner.nextLine();

            switch (userInput){
                case "1" :
                    addDrink();
                    break;
                case "2" :
                    addChip();
                    break;
                default :
                    System.out.println("Please choose correct option (1-2)");
            }
        }while (this.order.isOrderEmpty());
    }

    private Product signaturePhillyCheeseSteakSandwich() {
        Sandwich phillyCheeseSteak = new Sandwich(8,Bread.WHITE);
        phillyCheeseSteak.addMeat(Meat.STEAK);
        phillyCheeseSteak.addCheese(Cheese.CHEDDAR);
        phillyCheeseSteak.addToppings(Topping.LETTUCE);
        phillyCheeseSteak.addToppings(Topping.TOMATOES);
        phillyCheeseSteak.addSauce(Sauce.RANCH);
        phillyCheeseSteak.toastTheSandwich();
        return phillyCheeseSteak;
    }

    private Product signatureBLTSandwich() {
        Sandwich blt = new Sandwich(8,Bread.WHITE);
        blt.addMeat(Meat.BACON);
        blt.addCheese(Cheese.AMERICAN);
        blt.addToppings(Topping.PEPPERS);
        blt.addSauce(Sauce.MAYO);
        blt.toastTheSandwich();
        return blt;
    }

    private Sandwich getUserSandwich() {
        int userSandwichSize = getUserSandwichSize();
        Bread userSandwichBread = getUserSandwichBread();
        Sandwich sandwich = new Sandwich(userSandwichSize, userSandwichBread);
        System.out.println("Would you like to add Meat (Yes/No)");
        if ((scanner.nextLine()).equalsIgnoreCase("yes"))
            addMeat(sandwich);
        System.out.println("Would you like to add Cheese (Yes/No)");
        if ((scanner.nextLine()).equalsIgnoreCase("Yes"))
            addCheese(sandwich);
        System.out.println("Would you like to add toppings (yes/no)");
        if ((scanner.nextLine().equalsIgnoreCase("Yes")))
            addToppings(sandwich);
        System.out.println("Would you like to add another Sauces (Yes/No)");
        if ((scanner.nextLine()).equalsIgnoreCase("yes"))
            addSauces(sandwich);
        System.out.println("Would you like to add sides (Yes/No)");
        if ((scanner.nextLine()).equalsIgnoreCase("yes"))
            addSides(sandwich);
        System.out.println("Would you like to toast your sandwich(Yes/No)");
        if ((scanner.nextLine()).equalsIgnoreCase("yes"))
            toastTheSandwich(sandwich);
        return sandwich;
    }

    private static void toastTheSandwich(Sandwich sandwich) {
            sandwich.toastTheSandwich();
    }

    private void addSides(Sandwich sandwich) {

        String menu = """
                Please choose one of the followings:
                1) Au Jus
                2) Sauce
                ----------------------------------""";
        do {
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    sandwich.addSide(Side.AU_JUS);
                    break;
                case "2":
                    sandwich.addSide(Side.SAUCE);
                    break;
                default:
                    System.err.println("No side added," +
                            "Please choose correct option ");
            }
            System.out.println("Would you like to add another side (Yes/no)");
            if ((scanner.nextLine()).equalsIgnoreCase("no"))
                return;
        } while (true);
    }

    private void addSauces(Sandwich sandwich) {

        String menu = """
                Please choose one of the following:
                1) Mayo
                2) Mustard
                3) Ketchup
                4) Ranch
                5) Thousand Islands
                6) Vinaigrette
                """;
        do {
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput){
                case "1" :
                        sandwich.addSauce(Sauce.MAYO);
                        break;
                case "2" :
                        sandwich.addSauce(Sauce.MUSTARD);
                        break;
                case "3" :
                        sandwich.addSauce(Sauce.KETCHUP);
                        break;
                case "4" :
                        sandwich.addSauce(Sauce.RANCH);
                        break;
                case "5" :
                        sandwich.addSauce(Sauce.THOUSAND_ISLANDS);
                        break;
                case "6" :
                        sandwich.addSauce(Sauce.VINAIGRETTE);
                        break;
                default :
                        System.err.println("No sauce added, " +
                        "Please choose correct option.");
            }

            System.out.println("Would You like to add another Sauce (Yes/No)");
            if ((scanner.nextLine()).equalsIgnoreCase("no"))
                return;
        } while (true);
    }

    private void addToppings(Sandwich sandwich) {

        String menu = """
                Please choose one followings:
                1) Lettuce
                2) Peppers
                3) Onions
                4) Tomatoes
                5) Jalapenos
                6) Cucumbers
                7) Pikles
                8) Guacamole
                9) Mushrooms
                """;

        do {
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput){
                case "1" :
                        sandwich.addToppings(Topping.LETTUCE);
                        break;
                case "2" :
                        sandwich.addToppings(Topping.PEPPERS);
                        break;
                case "3" :
                        sandwich.addToppings(Topping.ONIONS);
                        break;
                case "4" :
                        sandwich.addToppings(Topping.TOMATOES);
                        break;
                case "5" :
                        sandwich.addToppings(Topping.JALAPENOS);
                        break;
                case "6" :
                        sandwich.addToppings(Topping.CUCUMBERS);
                        break;
                case "7" :
                        sandwich.addToppings(Topping.PICKLES);
                        break;
                case "8" :
                        sandwich.addToppings(Topping.GUACAMOLE);
                        break;
                case "9" :
                        sandwich.addToppings(Topping.MUSHROOMS);
                        break;
                default :
                        System.err.println("No topping added," +
                        "Please choose correct option");
            }
            System.out.println("Would you like to add another toppings (yes/no)");
            if ((scanner.nextLine()).equalsIgnoreCase("no"))
                return;
        } while (true);
    }

    private void addCheese(Sandwich sandwich) {
            sandwich.addCheese(getUserSandwichCheese());
            System.out.println("Would you like Extra Cheese (Yes/No)");
            if ((scanner.nextLine()).equalsIgnoreCase("yes"))
                sandwich.addExtraCheese();

    }

    private void addMeat(Sandwich sandwich) {

            sandwich.addMeat(getUserSandwichMeat());
            System.out.println("Would You like extra Meat (Yes/No)");
            if ((scanner.nextLine()).equalsIgnoreCase("yes"))
                sandwich.addExtraMeat();

    }

    private Cheese getUserSandwichCheese() {
        String menu = """
                Please choose one of the followings:
                1) American
                2) Provolone
                3) Cheddar
                4) Swiss
                """;

        do{
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1" :
                    return Cheese.AMERICAN;
                case "2" :
                    return Cheese.PROVOLONE;
                case "3" :
                    return Cheese.CHEDDAR;
                case "4" :
                    return Cheese.SWISS;
                default :
                        System.err.println("Please choose correct option");
            }

        }while (true);
    }

    private Meat getUserSandwichMeat() {
        String menu = """
                Please choose one of the following options:
                1) Steak
                2) Ham
                3) Salami
                4) Roast Beef
                5) Chicken
                6) Bacon
                """;
        do{
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput){
                case "1" :
                    return Meat.STEAK;
                case "2" :
                    return Meat.HAM;
                case "3" :
                    return Meat.SALAMI;
                case "4" :
                    return Meat.ROAST_BEEF;
                case "5" :
                    return Meat.CHICKEN;
                case "6" :
                    return Meat.BACON;
                default :
                        System.err.println("Please choose the correct Option.");
            }
        } while (true);
    }

    private Bread getUserSandwichBread() {
        String menu = """
                Please choose one of the following Bread:
                1) White
                2) Wheat
                3) Rye
                4) Wrap
                """;
        do {
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput){
                case "1" :
                    return Bread.WHITE;
                case "2" :
                    return Bread.WHEAT;
                case "3" :
                    return Bread.RYE;
                case "4" :
                    return Bread.WRAP;
                default :
                    System.err.println("Please choose the correct option." +
                        "\n And you can not have a Sandwich without Bread");

            }
        } while (true);
    }

    private int getUserSandwichSize() {
        String menu = """
                Please choose one of the following size:
                1) 4"
                2) 8"
                3) 12"
                """;
        do {
            System.out.println(menu);
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    return 4;
                case "2":
                    return 8;
                case "3" :
                    return 12;
                default :
                    System.err.println("Please Choose the correct option.");
            }
        } while (true);
    }

}