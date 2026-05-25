package com.pluralsight;

import com.pluralsight.enums.*;

import java.util.Scanner;

public class ShopUI {
    Order order;
    static Scanner scanner = new Scanner(System.in);
    private void mainMenu() {
        String menu = """
                Hello Welcome To Deli-cious Sandwich Shop
                Please choose one of the following:
                1) New Order
                0) Exit
                """;
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
                """;
        boolean running = true;
        do {
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> addSandwich();
                case "2" -> addDrink();
                case "3" -> addChip();
                case "4" ->{
                    checkout();
                    running = false;
                }
                case "0" ->{
                    cancelOrder();
                    running = false;
                }
            }

        }while (running);

    }
    // Done: Create the method
    private void cancelOrder() {
        this.order.clearOrder();
    }

    // TODO: Create the method
    private void checkout() {
    }

    // Done: Create the method
    private void addChip() {
        order.addProduct(new Chip());
    }

    //Done : Create the method
    private void addDrink() {
        String menu = """
                Please choose one of following size:
                1) Large
                2) Medium
                3) Small
                """;
        System.out.println(menu);
        String userInput = scanner.nextLine();
        switch (userInput){
            case "1" ->
                    this.order.addProduct(new Drink(Size.LARGE));
            case "2" ->
                    this.order.addProduct(new Drink(Size.MEDIUM));
            case "3" ->
                    this.order.addProduct(new Drink((Size.SMALL)));
            default ->
                    System.out.println("No Drinks added");
        }
    }

    //Done: Create the method
    private void addSandwich() {
        Sandwich sandwich = getUserSandwich();
        this.order.addProduct(sandwich);
    }

    private Sandwich getUserSandwich() {
        int userSandwichSize = getUserSandwichSize();
        Bread userSandwichBread = getUserSandwichBread();
        Sandwich sandwich = new Sandwich(userSandwichSize, userSandwichBread);
        addMeat(sandwich);
        addCheese(sandwich);
        addToppings(sandwich);
        addSauces(sandwich);
        addSides(sandwich);

        return sandwich;
    }

    private void addSides(Sandwich sandwich) {
        System.out.println("Would you like to add sides (Yes/No)");
        if ((scanner.nextLine()).equalsIgnoreCase("no"))
            return;
        String menu = """
                Please choose one of the followings:
                1) Au Jus
                2) Sauce
                """;
        while (true){
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput){
                case "1" -> sandwich.addSide(Side.AU_JUS);
                case "2" -> sandwich.addSide(Side.SAUCE);
                default -> System.err.println("No side added," +
                        "Please choose correct option ");
            }
            System.out.println("Would you like to add more side");
            if ((scanner.nextLine()).equalsIgnoreCase("no"))
                return;
        }
    }

    private void addSauces(Sandwich sandwich) {
        System.out.println("Would you like to add Sauces (Yes/No)");
        if ((scanner.nextLine()).equalsIgnoreCase("no"))
            return;
        String menu = """
                Please choose one of the following:
                1) Mayo
                2) Mustard
                3) Ketchup
                4) Ranch
                5) Thousand Islands
                6) Vinaigrette
                """;
        while (true){
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput){
                case "1" -> sandwich.addSauce(Sauce.MAYO);
                case "2" -> sandwich.addSauce(Sauce.MUSTARD);
                case "3" -> sandwich.addSauce(Sauce.KETCHUP);
                case "4" -> sandwich.addSauce(Sauce.RANCH);
                case "5" -> sandwich.addSauce(Sauce.THOUSAND_ISLANDS);
                case "6" -> sandwich.addSauce(Sauce.VINAIGRETTE);
                default -> System.err.println("No sauce added, " +
                        "Please choose correct option.");
            }
            System.out.println("Would You like to add more Sauce (Yes/No)");
            if ((scanner.nextLine()).equalsIgnoreCase("no"))
                return;
        }
    }

    private void addToppings(Sandwich sandwich) {
        System.out.println("Would you like to add toppings (yes/no)");
        if ((scanner.nextLine().equalsIgnoreCase("no")))
            return;
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
        while (true){
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput){
                case "1" -> sandwich.addToppings(Topping.LETTUCE);
                case "2" -> sandwich.addToppings(Topping.PEPPERS);
                case "3" -> sandwich.addToppings(Topping.ONIONS);
                case "4" -> sandwich.addToppings(Topping.TOMATOES);
                case "5" -> sandwich.addToppings(Topping.JALAPENOS);
                case "6" -> sandwich.addToppings(Topping.CUCUMBERS);
                case "7" -> sandwich.addToppings(Topping.PICKLES);
                case "8" -> sandwich.addToppings(Topping.GUACAMOLE);
                case "9" -> sandwich.addToppings(Topping.MUSHROOMS);
                default -> System.err.println("No topping added," +
                        "Please choose correct option");
            }
            System.out.println("Would you like to add more toppings (yes/no)");
            if ((scanner.nextLine()).equalsIgnoreCase("no"))
                return;
        }
    }


    private void addCheese(Sandwich sandwich) {
        System.out.println("Would you like to add Cheese (Yest/No)");
        if ((scanner.nextLine()).equalsIgnoreCase("Yes")){
            sandwich.addCheese(getUserSandwichCheese());
            System.out.println("Would you like Extra Cheese (Yes/No)");
            if ((scanner.nextLine()).equalsIgnoreCase("yes"))
                sandwich.addExtraCheese();
        }
    }

    private void addMeat(Sandwich sandwich) {
        System.out.println("Would you like to add Meat (Yes/No)");
        if ((scanner.nextLine()).equalsIgnoreCase("yes")){
            sandwich.addMeat(getUserSandwichMeat());
            System.out.println("Would You like extra Meat (Yes/No)");
            if ((scanner.nextLine()).equalsIgnoreCase("yes"))
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
        while (true){
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> {
                    return Cheese.AMERICAN;
                }
                case "2" -> {
                    return Cheese.PROVOLONE;
                }
                case "3" -> {
                    return Cheese.CHEDDAR;
                }
                case "4" -> {
                    return Cheese.SWISS;
                }
                default ->
                        System.err.println("Please choose correct option");
            }

        }
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
        while (true){
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput){
                case "1" -> {
                    return Meat.STEAK;
                }
                case "2" -> {
                    return Meat.HAM;
                }
                case "3" -> {
                    return Meat.SALAMI;
                }
                case "4" -> {
                    return Meat.ROAST_BEEF;
                }
                case "5" -> {
                    return Meat.CHICKEN;
                }
                case "6" -> {
                    return Meat.BACON;
                }
                default -> System.err.println("Please choose the correct Option.");
            }
        }
    }


    private Bread getUserSandwichBread() {
        String menu = """
                Please choose one of the following Bread:
                1) White
                2) Wheat
                3) Rye
                4) Wrap
                """;
        while (true){
            System.out.println(menu);
            String userInput = scanner.nextLine();
            switch (userInput){
                case "1" -> {
                    return Bread.WHITE;
                }
                case "2" -> {
                    return Bread.WHEAT;
                }
                case "3" -> {
                    return Bread.RYE;
                }
                case "4" ->{
                    return Bread.WRAP;
                }
                default -> System.err.println("Please choose the correct option." +
                        "\n And you can not have a Sandwich without Bread");

            }
        }
    }

    private int getUserSandwichSize() {
        int size;
        String menu = """
                Please choose one of the following size:
                1) 4"
                2) 8"
                3) 12"
                """;
        while (true){
            System.out.println(menu);
            String input = scanner.nextLine();
            switch (input){
                case "1"-> {
                    return 4;
                }
                case "2"->
                {
                    return 8;
                }
                case "3" ->
                {
                    return 12;
                }
                default -> System.err.println("Please Choose the correct option.");
            }
        }
    }

}