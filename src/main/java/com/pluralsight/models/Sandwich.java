package com.pluralsight.models;

import com.pluralsight.Product;
import com.pluralsight.pricing.SandwichPriceManager;
import com.pluralsight.enums.*;

import java.util.HashSet;

public class Sandwich implements Product {
    private final int size;
    private final Bread bread;
    private Meat meat;
    private Cheese cheese;
    private final HashSet<Topping> toppings;
    private final HashSet<Sauce> sauces;
    private final HashSet<Side> sides;
    private boolean extraMeat;
    private boolean extraChees;
    private boolean toasted;


    public Sandwich(int size, Bread bread) {
        this.size = size;
        this.bread = bread;
        this.toppings = new HashSet<>();
        this.sides = new HashSet<>();
        this.sauces = new HashSet<>();
    }

    public void addMeat(Meat meat){this.meat = meat;}
    public void addExtraMeat(){this.extraMeat = true;}
    public void addCheese(Cheese cheese){this.cheese = cheese;}
    public void addExtraCheese(){this.extraChees = true;}
    public void addToppings(Topping topping){this.toppings.add(topping);}
    public void addSauce(Sauce sauce){this.sauces.add(sauce);}
    public void addSide(Side side){this.sides.add(side);}
    public void toastTheSandwich(){this.toasted = true;}


    //Done: Create the method
    @Override
    public double getPrice() {
        double totalPrice = 0;
        totalPrice += SandwichPriceManager.getBreadPrice(this.size);
        if(this.meat != null)
            totalPrice += SandwichPriceManager.getMeatPrice(this.size);
        if (this.extraMeat)
            totalPrice += SandwichPriceManager.getExtraMeatPrice(this.size);
        if (this.cheese != null)
            totalPrice += SandwichPriceManager.getCheesePrice(this.size);
        if (extraChees)
            totalPrice += SandwichPriceManager.getExtraCheesePrice(this.size);
        return totalPrice;

    }
    // Done: Create the method
    @Override
    public String getProductName() {
        StringBuilder productName = new StringBuilder();
        productName.append("Sandwich Size: ").append(this.size).append(" Bread: ").append(this.bread).append("\n");
        if (!(this.meat == null))
            productName.append("Meat: ").append(this.meat).append("\n");
        if (!(this.cheese == null))
            productName.append("Cheese: ").append(this.cheese).append("\n");
        if (extraMeat)
            productName.append("Extra meat\n");
        if (extraChees)
            productName.append("Extra cheese\n");
        if(!this.toppings.isEmpty()) {
            productName.append("Toppings:\n");
            for (Topping topping : toppings)
                productName.append(topping).append(" ");
        }
        if (!this.sauces.isEmpty()) {
            productName.append("\nSauces:\n");
            for (Sauce sauce : sauces)
                productName.append(sauce).append(" ");
        }
        if (!this.sides.isEmpty()){
            productName.append("\nSides:\n");
            for (Side side : sides)
                productName.append(side).append(" ");
        }
        if (toasted)
            productName.append("\nToasted\n");
        productName.append("Price_____________________________").append(getPrice());

        return productName.toString();
    }
}
