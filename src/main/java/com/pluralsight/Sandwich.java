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
    //TODO : Create the method
    @Override
    public double getPrice() {
        return 0;
    }
    //TODO : Create the method
    @Override
    public String getProductName() {
        return "";
    }
}

