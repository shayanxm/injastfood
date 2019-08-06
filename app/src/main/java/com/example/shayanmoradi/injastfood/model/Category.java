package com.example.shayanmoradi.injastfood.model;

import java.util.List;

public class Category {
    private String mCategoryName;
    private int mCategoryId;
    private String mCategoryRestaurantName;
    private int mCategoryRestaurantId;

    private List<Food> mFoodsInCAtegory;

    public Category(String mCategoryName, int mCategoryId, String mCategoryRestaurantName, int mCategoryRestaurantId, List<Food> mFoodsInCAtegory) {
        this.mCategoryName = mCategoryName;
        this.mCategoryId = mCategoryId;
        this.mCategoryRestaurantName = mCategoryRestaurantName;
        this.mCategoryRestaurantId = mCategoryRestaurantId;
        this.mFoodsInCAtegory = mFoodsInCAtegory;
    }

    public String getmCategoryName() {
        return mCategoryName;
    }

    public int getmCategoryId() {
        return mCategoryId;
    }

    public String getmCategoryRestaurantName() {
        return mCategoryRestaurantName;
    }

    public int getmCategoryRestaurantId() {
        return mCategoryRestaurantId;
    }

    public List<Food> getmFoodsInCAtegory() {
        return mFoodsInCAtegory;
    }

}
