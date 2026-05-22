package com.pluralsight;

public class Chip implements Product{
    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String getProductName() {
        return "Chip\nPrice_____________________________"+getPrice();
    }
}
