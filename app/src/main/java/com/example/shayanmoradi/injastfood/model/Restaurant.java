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
    private double mRestaurantOff;
    private String mRestaurantDes;
    private String mRestaurantAddress;
    private List<Category>mRestaurantCategoreis;
    private List<Food>mRestaurantAllFoods;
    private double mRestaurantDeliveryPrice;
    private int mRestaurantImageAddress;
    private int mRestaurantSecondImageAddress;
    private Partiation mRestKind;

    public Restaurant(int mRestaurantId, String mRestaurantName, int mRestaurantRate, double mRestaurantOff, String mRestaurantDes, String mRestaurantAddress, List<Category> mRestaurantCategoreis, List<Food> mRestaurantAllFoods, double mRestaurantDeliveryPrice, int mRestaurantImageAddress, int mRestaurantSecondImageAddress, Partiation mRestKind) {
        this.mRestaurantId = mRestaurantId;
        this.mRestaurantName = mRestaurantName;
        this.mRestaurantRate = mRestaurantRate;
        this.mRestaurantOff = mRestaurantOff;
        this.mRestaurantDes = mRestaurantDes;
        this.mRestaurantAddress = mRestaurantAddress;
        this.mRestaurantCategoreis = mRestaurantCategoreis;
        this.mRestaurantAllFoods = mRestaurantAllFoods;
        this.mRestaurantDeliveryPrice = mRestaurantDeliveryPrice;
        this.mRestaurantImageAddress = mRestaurantImageAddress;
        this.mRestaurantSecondImageAddress = mRestaurantSecondImageAddress;
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

    public int getmRestaurantImageAddress() {
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

    public double getmRestaurantOff() {
        return mRestaurantOff;
    }

    public int getmRestaurantSecondImageAddress() {
        return mRestaurantSecondImageAddress;
    }
}
