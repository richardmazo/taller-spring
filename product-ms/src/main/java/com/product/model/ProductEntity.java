package com.product.model;

public class ProductEntity {

    private int id;
    private String name;
    private String information;
    private double price;
    private int stock;

    public ProductEntity(int id, String name, String information, double price, int stock) {
        this.id = id;
        this.name = name;
        this.information = information;
        this.price = price;
        this.stock = stock;
    }

    public ProductEntity(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
