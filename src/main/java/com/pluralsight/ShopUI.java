package com.pluralsight;

import java.util.Scanner;

public class ShopUI {
    Order order;
    static Scanner scanner = new Scanner(System.in);
    private void mainMenu() {
        String menu = """
                Hello Welcome To Deli-cious Sandwich Shop
                Please chose one of the following:
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
                Please chose one of the following:
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

    // TODO: Create the method
    private void addChip() {
    }

    //TODO : Create the method
    private void addDrink() {
    }

    //TODO: Create the method
    private void addSandwich() {
    }

}
