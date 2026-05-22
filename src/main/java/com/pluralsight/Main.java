package com.pluralsight;

import com.pluralsight.enums.*;

public class Main {
    public static void main(String[] args) {
        Sandwich s = new Sandwich(12,Bread.WHEAT, Meat.CHICKEN,true,Cheese.AMERICAN,true);
        s.toastTheSandwich();
        Chip c = new Chip();
        System.out.println(c.getProductName());
        System.out.println(s.getProductName());


    }
}
