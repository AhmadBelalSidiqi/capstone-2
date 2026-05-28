package com.pluralsight.Sandwich_Ingrediant_Price;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SandwichPriceManger {

    public static final String SRC_MAIN_RESOURCES_INGREDIENTS_PRICE_CSV = "src/main/resources/IngredientsPrice.csv";

    private static double ingredientPrice(int size, String ingredient){
        try {
            FileReader fileReader = new FileReader(SRC_MAIN_RESOURCES_INGREDIENTS_PRICE_CSV);
            BufferedReader reader = new BufferedReader(fileReader);
            String ingredientPriceForThisSize = "SIZE_"+size+"_" + ingredient;
            String currentLine;
            while ((currentLine = reader.readLine())!= null){
                if (currentLine.startsWith(ingredientPriceForThisSize)){
                    reader.close();
                    String[] spiltThePrice = currentLine.split(",");
                    return Double.parseDouble(spiltThePrice[1]);
                }
            }
            reader.close();
            throw new RuntimeException(ingredient+" for, SIZE: "+size+" not found");
        }catch (IOException e){
            throw new RuntimeException( e + "File not found ");
        }
    }

    public static double getBreadPrice(int size){
        return ingredientPrice(size,"BREAD_PRICE");
    }
    public static double getMeatPrice(int size){
        return ingredientPrice(size,"MEAT_PRICE");
    }
    public static double getExtraMeatPrice(int size){
        return ingredientPrice(size,"EXTRA_MEAT_PRICE");
    }
    public static double getCheesePrice(int size){
        return ingredientPrice(size, "CHEESE_PRICE");
    }
    public static double getExtraCheesePrice(int size){
        return ingredientPrice(size,"EXTRA_CHEESE_PRICE");
    }
}