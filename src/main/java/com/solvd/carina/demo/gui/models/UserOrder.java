package com.solvd.carina.demo.gui.models;

public class UserOrder {
    private int id;
    private int userId;
    private String productName;
    private double price;

    public UserOrder(int id, int userId, String productName, double price) {
        this.id = id;
        this.userId = userId;
        this.productName = productName;
        this.price = price;
    }

    public UserOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "id=" + id +
                ", userId=" + userId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}