package com.example.demo.DTO;

import com.example.demo.Entity.User;

public class ItemDTO {
    private String name;
    private String category;
    private int quantity;
    private int price;
    private String sellerName;
    private String BuyerName;


    public ItemDTO(String name, String category, int quantity, int price, String sellerName, String buyerName) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.sellerName = sellerName;
        BuyerName = buyerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getBuyerName() {
        return BuyerName;
    }

    public void setBuyerName(String buyerName) {
        BuyerName = buyerName;
    }
}
