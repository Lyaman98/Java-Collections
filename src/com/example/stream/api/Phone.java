package com.example.stream.api;

public class Phone {

    private String phoneName;
    private double price;

    public Phone(String phoneName, double price) {
        this.phoneName = phoneName;
        this.price = price;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
