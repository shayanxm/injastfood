package com.example.shayanmoradi.injastfood.model;

public class Food {
    private int mfoodId;
    private String mfoodName;
    private int mfoodPrice;
    private double mfoodOff;
    private int mfoodRate;
    private String mfoodRestaurantName;
    private String mfoodCategoryName;
    private String mfoodImageAddress;

    public Food(int mfoodId, String mfoodName, int mfoodPrice, double mfoodOff, int mfoodRate, String mfoodRestaurantName, String mfoodCategoryName, String mfoodImageAddress) {
        this.mfoodId = mfoodId;
        this.mfoodName = mfoodName;
        this.mfoodPrice = mfoodPrice;
        this.mfoodOff = mfoodOff;
        this.mfoodRate = mfoodRate;
        this.mfoodRestaurantName = mfoodRestaurantName;
        this.mfoodCategoryName = mfoodCategoryName;
        this.mfoodImageAddress = mfoodImageAddress;
    }

    public int getMfoodId() {
        return mfoodId;
    }

    public String getMfoodName() {
        return mfoodName;
    }

    public int getMfoodPrice() {
        return mfoodPrice;
    }

    public double getMfoodOff() {
        return mfoodOff;
    }

    public int getMfoodRate() {
        return mfoodRate;
    }

    public String getMfoodRestaurantName() {
        return mfoodRestaurantName;
    }

    public String getMfoodCategoryName() {
        return mfoodCategoryName;
    }

    public String getMfoodImageAddress() {
        return mfoodImageAddress;
    }
}
