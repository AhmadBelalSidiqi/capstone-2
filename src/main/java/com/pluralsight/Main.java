package com.pluralsight;

import com.pluralsight.Sandwich_Ingrediant_Price.SandwichPriceManger;

public class Main {
    public static void main(String[] args) {
//        ShopUI shopUI = new ShopUI();
//        shopUI.mainMenu();
        System.out.println(SandwichPriceManger.getBreadPrice(4));
        System.out.println(SandwichPriceManger.getBreadPrice(8));
        System.out.println(SandwichPriceManger.getBreadPrice(12));
        System.out.println("---------------------");
        System.out.println(SandwichPriceManger.getMeatPrice(4));
        System.out.println(SandwichPriceManger.getMeatPrice(8));
        System.out.println(SandwichPriceManger.getMeatPrice(12));
        System.out.println("----------------------");
        System.out.println(SandwichPriceManger.getCheesePrice(4)
                +SandwichPriceManger.getMeatPrice(4));
        //this one must fail.....
        System.out.println(SandwichPriceManger.getBreadPrice(20));


    }
}
