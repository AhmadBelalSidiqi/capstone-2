package com.pluralsight;

import com.pluralsight.enums.*;

import java.util.HashSet;

public class Sandwich implements Product{
    private final int size;
    private Bread bread;
    private Meat meat;
    private Cheese cheese;
    private HashSet<Topping> toppings;
    private HashSet<Sauce> sauces;
    private HashSet<Side> sides;
    private boolean extraMeat;
    private boolean extraChees;
    private boolean toasted;


    public Sandwich(int size, Bread bread, Meat meat, boolean extraMeat, Cheese cheese, boolean extraChees) {
        this.size = size;
        this.bread = bread;
        this.meat = meat;
        this.extraMeat = extraMeat;
        this.cheese = cheese;
        this.extraChees = extraChees;
        this.toppings = new HashSet<>();
        this.sauces = new HashSet<>();
        this.sides = new HashSet<>();
    }
    public void toastTheSandwich(){this.toasted = true;}
    public void addToppings(Topping topping){this.toppings.add(topping);}
    public void addSauce(Sauce sauce){this.sauces.add(sauce);}
    public void addSide(Side side){this.sides.add(side);}


    //Done: Create the method
    @Override
    public double getPrice() {
        double totalPrice = 0;
        switch (this.size){
            case 4->{
                totalPrice += 7.25;
                if (extraMeat)
                    totalPrice += 0.50;
                if (extraChees)
                    totalPrice += 0.30;
                return totalPrice;
            }
            case 8->{
                totalPrice += 10.5;
                if (extraMeat)
                    totalPrice += 1;
                if (extraChees)
                    totalPrice += 0.60;
                return totalPrice;
            }
            case 12->{
                totalPrice += 13.75;
                if (extraMeat)
                    totalPrice += 1.50;
                if (extraChees)
                    totalPrice += 0.90;
                return totalPrice;
            }
            default ->
                    throw new RuntimeException();
        }
    }
    // Done: Create the method
    @Override
    public String getProductName() {
        StringBuilder productName = new StringBuilder();
        productName.append("Sandwich Size: ").append(this.size).append(" Bread: ").append(this.bread).append(" Meat: ").append(this.meat).append(" Cheese: ").append(this.cheese).append("\n");
        if (extraMeat)
            productName.append("Extra meat\n");
        if (extraChees)
            productName.append("Extra cheese\n");
        if(!toppings.isEmpty()) {
            productName.append("Toppings:\n");
            for (Topping topping : toppings)
                productName.append(topping).append("\t");
        }
        if (!sauces.isEmpty()) {
            productName.append("\nSauces:\n");
            for (Sauce sauce : sauces)
                productName.append(sauce).append("\t");
        }
        if (!sides.isEmpty()){
            productName.append("\nSides:\n");
            for (Side side : sides)
                productName.append(side).append("\t");
        }
        if (toasted)
            productName.append("Toasted\n");
        productName.append("Price_________________________________________________").append(getPrice());

        return productName.toString();
    }
}
