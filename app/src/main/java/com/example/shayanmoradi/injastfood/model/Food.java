package com.example.shayanmoradi.injastfood.model;

public class Food {
    private int mfoodId;
    private String mfoodName;
    private int mfoodPrice;
    private double mfoodOff;
    private int mfoodRate;
    private String mfoodDes;
    private String mfoodRestaurantName;
    private String mfoodCategoryName;
    private int mfoodImageAddress;
    private int mFoodInBagCount=0;

    public Food(int mfoodId, String mfoodName, int mfoodPrice, double mfoodOff, int mfoodRate, String mfoodDes, String mfoodRestaurantName, String mfoodCategoryName, int mfoodImageAddress, int mFoodInBagCount) {
        this.mfoodId = mfoodId;
        this.mfoodName = mfoodName;
        this.mfoodPrice = mfoodPrice;
        this.mfoodOff = mfoodOff;
        this.mfoodRate = mfoodRate;
        this.mfoodDes = mfoodDes;
        this.mfoodRestaurantName = mfoodRestaurantName;
        this.mfoodCategoryName = mfoodCategoryName;
        this.mfoodImageAddress = mfoodImageAddress;
        this.mFoodInBagCount = mFoodInBagCount;
    }

    public Food(int mfoodId, String mfoodName, int mfoodPrice, double mfoodOff, int mfoodRate, String mfoodDes, String mfoodRestaurantName, String mfoodCategoryName, int mfoodImageAddress) {
        this.mfoodId = mfoodId;
        this.mfoodName = mfoodName;
        this.mfoodPrice = mfoodPrice;
        this.mfoodOff = mfoodOff;
        this.mfoodRate = mfoodRate;
        this.mfoodDes = mfoodDes;
        this.mfoodRestaurantName = mfoodRestaurantName;
        this.mfoodCategoryName = mfoodCategoryName;
        this.mfoodImageAddress = mfoodImageAddress;
    }

    public void setmFoodInBagCount(int mFoodInBagCount) {
        this.mFoodInBagCount = mFoodInBagCount;
    }

    public int getmFoodInBagCount() {
        return mFoodInBagCount;
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

    public int getMfoodImageAddress() {
        return mfoodImageAddress;
    }

    public String getMfoodDes() {
        return mfoodDes;
    }
}
