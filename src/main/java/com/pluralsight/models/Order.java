package com.pluralsight.models;

import com.pluralsight.Product;

import java.util.ArrayList;

public class Order {
    private final ArrayList<Product> products;

    public Order() {
        this.products = new ArrayList<>();
    }

    public String showOrder(){
        StringBuilder order = new StringBuilder();
        int count = 1;
        for (Product product : products){
            order.append("Item: ").append(count).append("#\n").append(product.getProductName()).append("\n");
            count++;
        }
        order.append("\nYour Total : ").append(getTotalPrice());
        return order.toString();
    }
    public double getTotalPrice(){
        double totalPrice =0;
        for(Product product: products)
            totalPrice += product.getPrice();
        // Sales Tax is 7%
        return totalPrice;
    }
    public void addProduct(Product product){
        this.products.add(product);
    }
    public boolean isOrderEmpty(){
        return this.products.isEmpty();
    }
    public void clearOrder(){
        this.products.clear();
    }

}
