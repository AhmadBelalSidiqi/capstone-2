package com.pluralsight;

import java.util.ArrayList;

public class Order {
   private ArrayList<Product> products;
   public static int receiptsCount;

    public Order() {
        this.products = new ArrayList<>();
        receiptsCount ++;
    }

    public void showReceipt(){
        int count = 1;
        for (Product product : products){
            System.out.println(count +"#\n ");
            product.getProductName();
        }
        System.out.println("\nYour Total price plus tax is: " + getTotalPrice());
    }
    public double getTotalPrice(){
        double totalPrice =0;
        for(Product product: products)
            totalPrice += product.getPrice();
        // Sales Tax is 7%
        return totalPrice * 1.07;
    }
    public void addProduct(Product product){
        this.products.add(product);
    }
    public boolean isOrderEmpty(){
        return this.products.isEmpty();
    }
    public void clearOrder(){
        this.products.clear();
        receiptsCount --;
    }

}
