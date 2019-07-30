package com.example.shayanmoradi.injastfood.model;

import java.util.List;

public class Restaurant {
    private int mRestaurantId;
    private String mRestaurantName;
    private int mRestaurantRate;
    private String getmRestaurantDes;
    private List<Category>mRestaurantCategoreis;
    private List<Food>mRestaurantAllFoods;
    private double mRestaurantDeliveryPrice;
    private String mRestaurantImageAddress;

    public Restaurant(int mRestaurantId, String mRestaurantName, int mRestaurantRate, String getmRestaurantDes, List<Category> mRestaurantCategoreis, List<Food> mRestaurantAllFoods, double mRestaurantDeliveryPrice, String mRestaurantImageAddress) {
        this.mRestaurantId = mRestaurantId;
        this.mRestaurantName = mRestaurantName;
        this.mRestaurantRate = mRestaurantRate;
        this.getmRestaurantDes = getmRestaurantDes;
        this.mRestaurantCategoreis = mRestaurantCategoreis;
        this.mRestaurantAllFoods = mRestaurantAllFoods;
        this.mRestaurantDeliveryPrice = mRestaurantDeliveryPrice;
        this.mRestaurantImageAddress = mRestaurantImageAddress;
    }
}
