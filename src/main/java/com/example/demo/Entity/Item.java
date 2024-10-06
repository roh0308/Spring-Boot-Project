package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String category;
    private int quantity;
    private int price;
    private boolean isSold;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User sellerName;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User BuyerName;

    public Item(String name, String category, int quantity, int price,boolean isSold, User sellerName, User buyerName) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.isSold = isSold;
        this.sellerName = sellerName;
        BuyerName = buyerName;
    }

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public User getSellerName() {
        return sellerName;
    }

    public void setSellerName(User sellerName) {
        this.sellerName = sellerName;
    }

    public User getBuyerName() {
        return BuyerName;
    }

    public void setBuyerName(User buyerName) {
        BuyerName = buyerName;
    }
}
