package com.pluralsight.models;

import com.pluralsight.Product;
import com.pluralsight.enums.Size;

public class Drink implements Product {
    private final Size size;

    public Drink(Size size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        switch (size){
            case LARGE -> {
                return 3;
            }
            case MEDIUM -> {
                return 2.50;
            }
            case SMALL ->{
                return 2;
            }
            default ->
                throw new RuntimeException();
        }
    }

    @Override
    public String getProductName() {
        return "Drink\nSize: "+this.size+"\nPrice_____________________________"+getPrice();
    }
}
