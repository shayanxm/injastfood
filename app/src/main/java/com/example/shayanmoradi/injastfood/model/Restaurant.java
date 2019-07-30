package com.example.shayanmoradi.injastfood.model;

import java.util.List;

public class Restaurant {
   public enum Partiation
    {
        REsturant,Candy,Caffe,Others
    }
    private int mRestaurantId;
    private String mRestaurantName;
    private int mRestaurantRate;
    private String mRestaurantDes;
    private String mRestaurantAddress;
    private List<Category>mRestaurantCategoreis;
    private List<Food>mRestaurantAllFoods;
    private double mRestaurantDeliveryPrice;
    private String mRestaurantImageAddress;
    private Partiation mRestKind;

    public Restaurant(int mRestaurantId, String mRestaurantName, int mRestaurantRate, String mRestaurantDes, String mRestaurantAddress, List<Category> mRestaurantCategoreis, List<Food> mRestaurantAllFoods, double mRestaurantDeliveryPrice, String mRestaurantImageAddress, Partiation mRestKind) {
        this.mRestaurantId = mRestaurantId;
        this.mRestaurantName = mRestaurantName;
        this.mRestaurantRate = mRestaurantRate;
        this.mRestaurantDes = mRestaurantDes;
        this.mRestaurantAddress = mRestaurantAddress;
        this.mRestaurantCategoreis = mRestaurantCategoreis;
        this.mRestaurantAllFoods = mRestaurantAllFoods;
        this.mRestaurantDeliveryPrice = mRestaurantDeliveryPrice;
        this.mRestaurantImageAddress = mRestaurantImageAddress;
        this.mRestKind = mRestKind;
    }

    public int getmRestaurantId() {

        return mRestaurantId;
    }

    public String getmRestaurantName() {
        return mRestaurantName;
    }

    public int getmRestaurantRate() {
        return mRestaurantRate;
    }



    public List<Category> getmRestaurantCategoreis() {
        return mRestaurantCategoreis;
    }

    public List<Food> getmRestaurantAllFoods() {
        return mRestaurantAllFoods;
    }

    public double getmRestaurantDeliveryPrice() {
        return mRestaurantDeliveryPrice;
    }

    public String getmRestaurantImageAddress() {
        return mRestaurantImageAddress;
    }

    public String getmRestaurantDes() {
        return mRestaurantDes;
    }

    public String getmRestaurantAddress() {
        return mRestaurantAddress;
    }

    public Partiation getmRestKind() {
        return mRestKind;
    }
}
