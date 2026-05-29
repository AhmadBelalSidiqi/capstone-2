package com.pluralsight;

import com.pluralsight.enums.*;
import com.pluralsight.models.Chip;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;

import java.util.Scanner;

public class ShopUI {
    private Order order;
    private static final Scanner scanner = new Scanner(System.in);

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
            String selectedOption = scanner.nextLine();
            switch (selectedOption) {
                case "1":
                    orderScreen();
                    break;
                case "0":
                    running = false;
                    System.out.println("Thank you have a nice day");
                    break;
                default:
                    System.err.println("Please enter valid input (0-1)");
            }
        } while (running);

    }

    private void orderScreen() {
        this.order = new Order();
        String menu = """
                --------------------------------------
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
            String selectedOption = scanner.nextLine();
            switch (selectedOption) {
                case "1":
                    addSandwich();
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChip();
                    break;
                case "4":
                    checkout();
                    running = false;
                    break;
                case "0":
                    cancelOrder();
                    running = false;
                    break;
                default:
                    System.err.println("Please enter valid input(0-4)");
            }

        } while (running);

    }

    private void addSandwich() {
        String menu = """
                ------------------------------------------
                Please Choose one of the following options
                1) Make your own sandwich
                2) BLT Sandwich
                3) Philly Cheese Steak
                ------------------------------------------""";
        do {
            System.out.println(menu);
            String selectedOption = scanner.nextLine();
            switch (selectedOption) {
                case "1":
                    this.order.addProduct(getUserCustomSandwich());
                    System.out.println("Your custom sandwich added to order");
                    return;
                case "2":
                    this.order.addProduct(signatureBLTSandwich());
                    System.out.println("BLT sandwich added to order");
                    return;
                case "3":
                    this.order.addProduct(signaturePhillyCheeseSteakSandwich());
                    System.out.println("Philly Cheese Steak added to order");
                    return;
                default:
                    System.err.println("Please enter valid input(1-3)");
            }
        } while (true);

    }

    private void addChip() {
        order.addProduct(new Chip());
        System.out.println("Chip added");
    }

    private void addDrink() {
        String menu = """
                -------------------------------------
                Please choose one of following size:
                1) Large
                2) Medium
                3) Small
                ------------------------------------""";
        System.out.println(menu);
        String selectedOption = scanner.nextLine();
        switch (selectedOption) {
            case "1":
                this.order.addProduct(new Drink(Size.LARGE));
                System.out.println("Drink: "+Size.LARGE+" added");
                break;
            case "2":
                this.order.addProduct(new Drink(Size.MEDIUM));
                System.out.println("Drink: "+Size.MEDIUM+" added");

                break;
            case "3":
                this.order.addProduct(new Drink((Size.SMALL)));
                System.out.println("Drink: "+Size.SMALL+" added");
                break;
            default:
                System.err.println("No Drinks Added");
        }
    }

    private void checkout() {
        if (this.order.isOrderEmpty())
            enforceAPurchase();
        System.out.println("---------- Order Summary ---------");
        displayOrder();
        System.out.println("--------------------------");
        if (askYesNo("Please confirm if the order is correct")) {
            ReceiptFileManager.saveReceipt(this.order);
            System.out.println("Order placed successfully");
            order.clearOrder();
            return;
        }
        order.clearOrder();
        System.out.println("Order Canceled.");
    }

    private void cancelOrder() {
        this.order.clearOrder();
        System.out.println("Order canceled");
    }

    private void displayOrder() {
        System.out.println(this.order.showOrder());
    }

    private void enforceAPurchase() {
        String menu = """
                Your order is empty,
                To complete your checkout,
                you have to buy one of the followings items
                1) Add Drink
                2) Add Chip
                ----------------------------------""";
        do {
            System.out.println(menu);
            String selectedOption = scanner.nextLine();

            switch (selectedOption) {
                case "1":
                    addDrink();
                    break;
                case "2":
                    addChip();
                    break;
                default:
                    System.err.println("Please enter valid input (1-2)");
            }
        } while (this.order.isOrderEmpty());
    }

    private Product signaturePhillyCheeseSteakSandwich() {
        Sandwich phillyCheeseSteak = new Sandwich(8, Bread.WHITE);
        phillyCheeseSteak.addMeat(Meat.STEAK);
        phillyCheeseSteak.addCheese(Cheese.CHEDDAR);
        phillyCheeseSteak.addToppings(Topping.LETTUCE);
        phillyCheeseSteak.addToppings(Topping.TOMATOES);
        phillyCheeseSteak.addSauce(Sauce.RANCH);
        phillyCheeseSteak.toastTheSandwich();
        return phillyCheeseSteak;
    }

    private Product signatureBLTSandwich() {
        Sandwich blt = new Sandwich(8, Bread.WHITE);
        blt.addMeat(Meat.BACON);
        blt.addCheese(Cheese.AMERICAN);
        blt.addToppings(Topping.PEPPERS);
        blt.addSauce(Sauce.MAYO);
        blt.toastTheSandwich();
        return blt;
    }

    private Sandwich getUserCustomSandwich() {
        int userSandwichSize = buildCustomSandwich();
        Bread userSandwichBread = getUserSandwichBread();
        Sandwich sandwich = new Sandwich(userSandwichSize, userSandwichBread);
        if (askYesNo("Would you like to add Meat"))
            addMeat(sandwich);
        if (askYesNo("Would you like to add Cheese"))
            addCheese(sandwich);
        if (askYesNo("Would you like to add toppings"))
            addToppings(sandwich);
        if (askYesNo("Would you like to add sauces"))
            addSauces(sandwich);
        if (askYesNo("Would you like to add sides"))
            addSidesToSandwich(sandwich);
        if (askYesNo("Would you like to toast your sandwich"))
            toastTheSandwich(sandwich);
        return sandwich;
    }

    private static void toastTheSandwich(Sandwich sandwich) {
        sandwich.toastTheSandwich();
        System.out.println("Sandwich toasted");
    }

    private void addSidesToSandwich(Sandwich sandwich) {

        String menu = """
                Please choose one of the followings:
                1) Au Jus
                2) Sauce
                ----------------------------------""";
        do {
            System.out.println(menu);
            String selectedOption = scanner.nextLine();
            switch (selectedOption) {
                case "1":
                    sandwich.addSide(Side.AU_JUS);
                    System.out.println("Side: "+ Side.AU_JUS+" added");
                    break;
                case "2":
                    sandwich.addSide(Side.SAUCE);
                    System.out.println("Side: "+ Side.SAUCE+" added");
                    break;
                default:
                    System.err.println("No side added," +
                            "Please enter a valid option ");
            }
            if (!askYesNo("Would you like to add another side")) {
                return;
            }
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
            String selectedOption = scanner.nextLine();
            switch (selectedOption) {
                case "1":
                    sandwich.addSauce(Sauce.MAYO);
                    System.out.println("Sauce: "+Sauce.MAYO+" added");
                    break;
                case "2":
                    sandwich.addSauce(Sauce.MUSTARD);
                    System.out.println("Sauce: "+Sauce.MUSTARD+" added");
                    break;
                case "3":
                    sandwich.addSauce(Sauce.KETCHUP);
                    System.out.println("Sauce: "+Sauce.KETCHUP+" added");
                    break;
                case "4":
                    sandwich.addSauce(Sauce.RANCH);
                    System.out.println("Sauce: "+Sauce.RANCH+" added");
                    break;
                case "5":
                    sandwich.addSauce(Sauce.THOUSAND_ISLANDS);
                    System.out.println("Sauce: "+Sauce.THOUSAND_ISLANDS+" added");
                    break;
                case "6":
                    sandwich.addSauce(Sauce.VINAIGRETTE);
                    System.out.println("Sauce: "+Sauce.VINAIGRETTE+" added");
                    break;
                default:
                    System.err.println("No sauce added, " +
                            "Please enter a valid option.");
            }

            if (!askYesNo("Would You like to add another Sauce"))
                return;
        } while (true);
    }

    private void addToppings(Sandwich sandwich) {

        String menu = """
                Please choose one of following:
                1) Lettuce
                2) Peppers
                3) Onions
                4) Tomatoes
                5) Jalapenos
                6) Cucumbers
                7) Pickles
                8) Guacamole
                9) Mushrooms
                """;

        do {
            System.out.println(menu);
            String selectedOption = scanner.nextLine();
            switch (selectedOption) {
                case "1":
                    sandwich.addToppings(Topping.LETTUCE);
                    System.out.println("Topping: "+Topping.LETTUCE+" Added");
                    break;
                case "2":
                    sandwich.addToppings(Topping.PEPPERS);
                    System.out.println("Topping: "+Topping.PEPPERS+" Added");
                    break;
                case "3":
                    sandwich.addToppings(Topping.ONIONS);
                    System.out.println("Topping: "+Topping.ONIONS+" Added");
                    break;
                case "4":
                    sandwich.addToppings(Topping.TOMATOES);
                    System.out.println("Topping: "+Topping.TOMATOES+" Added");
                    break;
                case "5":
                    sandwich.addToppings(Topping.JALAPENOS);
                    System.out.println("Topping: "+Topping.JALAPENOS+" Added");
                    break;
                case "6":
                    sandwich.addToppings(Topping.CUCUMBERS);
                    System.out.println("Topping: "+Topping.CUCUMBERS+" Added");
                    break;
                case "7":
                    sandwich.addToppings(Topping.PICKLES);
                    System.out.println("Topping: "+Topping.PICKLES+" Added");
                    break;
                case "8":
                    sandwich.addToppings(Topping.GUACAMOLE);
                    System.out.println("Topping: "+Topping.GUACAMOLE+" Added");
                    break;
                case "9":
                    sandwich.addToppings(Topping.MUSHROOMS);
                    System.out.println("Topping: "+Topping.MUSHROOMS+" Added");
                    break;
                default:
                    System.err.println("No topping added," +
                            "Please enter a valid option");
            }
            if (!askYesNo("Would you like to add another toppings"))
                return;
        } while (true);
    }

    private void addCheese(Sandwich sandwich) {
        sandwich.addCheese(getUserSandwichCheese());
        System.out.println("Cheese added");
        String prompt = """
                Would You like extra cheese ?
                Cost - 0.30 - for 4" Sandwich
                Cost - 0.60 - for 8" Sandwich
                Cost - 0.90 - for 12" Sandwich
                """;
        if (askYesNo(prompt)) {
            System.out.println("Extra Cheese Added");
            sandwich.addExtraCheese();
        }

    }

    private void addMeat(Sandwich sandwich) {
        sandwich.addMeat(getUserSandwichMeat());
        System.out.println("Meat Added");
        String prompt = """
                Would You like extra meat ?
                Cost - 0.50 - for 4" Sandwich
                Cost - 1.00 - for 8" Sandwich
                Cost - 1.50 - for 12" Sandwich
                """;
        if (askYesNo(prompt)) {
            System.out.println("Extra Meat Added");
            sandwich.addExtraMeat();
        }

    }

    private Cheese getUserSandwichCheese() {
        String menu = """
                Please choose one of the followings:
                1) American
                2) Provolone
                3) Cheddar
                4) Swiss
                """;

        do {
            System.out.println(menu);
            String selectedOption = scanner.nextLine();
            switch (selectedOption) {
                case "1":
                    return Cheese.AMERICAN;
                case "2":
                    return Cheese.PROVOLONE;
                case "3":
                    return Cheese.CHEDDAR;
                case "4":
                    return Cheese.SWISS;
                default:
                    System.err.println("Please enter a valid option");
            }

        } while (true);
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
        do {
            System.out.println(menu);
            String selectedOption = scanner.nextLine();
            switch (selectedOption) {
                case "1":
                    return Meat.STEAK;
                case "2":
                    return Meat.HAM;
                case "3":
                    return Meat.SALAMI;
                case "4":
                    return Meat.ROAST_BEEF;
                case "5":
                    return Meat.CHICKEN;
                case "6":
                    return Meat.BACON;
                default:
                    System.err.println("Please enter a valid Option.");
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
            String selectedOption = scanner.nextLine();
            switch (selectedOption) {
                case "1":
                    return Bread.WHITE;
                case "2":
                    return Bread.WHEAT;
                case "3":
                    return Bread.RYE;
                case "4":
                    return Bread.WRAP;
                default:
                    System.err.println("Please enter a valid option(1-4)." +
                            "\n And you can not have a Sandwich without Bread");

            }
        } while (true);
    }

    private int buildCustomSandwich() {
        String menu = """
                Please choose one of the following size:
                1) 4"
                2) 8"
                3) 12"
                """;
        do {
            System.out.println(menu);
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    return 4;
                case "2":
                    return 8;
                case "3":
                    return 12;
                default:
                    System.err.println("Please enter a valid option (1-3).");
            }
        } while (true);
    }

    private boolean askYesNo(String message) {
        System.out.println(message + " (yes/no)");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("yes");
    }

}