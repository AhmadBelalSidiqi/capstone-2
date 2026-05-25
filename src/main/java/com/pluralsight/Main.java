package com.pluralsight;

import com.pluralsight.enums.*;

public class Main {
    public static void main(String[] args) {
        Sandwich s = new Sandwich(12,Bread.WHEAT);
        s.addMeat(Meat.CHICKEN);
        s.addSide(Side.SAUCE);
        s.addSide(Side.AU_JUS);
        s.addExtraCheese();
        s.addExtraMeat();
        s.addCheese(Cheese.AMERICAN);
        s.addToppings(Topping.CUCUMBERS);
        s.addToppings(Topping.LETTUCE);
        s.toastTheSandwich();
        Chip c = new Chip();
        Drink d = new Drink(Size.LARGE);
        System.out.println(c.getProductName());
        System.out.println(s.getProductName());
        System.out.println(d.getProductName());


    }
}
