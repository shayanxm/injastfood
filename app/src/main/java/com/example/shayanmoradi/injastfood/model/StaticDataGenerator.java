package com.example.shayanmoradi.injastfood.model;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaticDataGenerator {

    private static StaticDataGenerator instance;

    private Context mContext;

    public static List<Restaurant> mAllRestList;
    private static List<Integer> mRestaurantId = Arrays.asList(new Integer[]{12, 13, 14});
    private static List<String> mRestaurantName = Arrays.asList(new String[]{"pizzahot", "kababi", "pasta"});
    private static List<Integer> mRestaurantRate = Arrays.asList(new Integer[]{13, 12, 14});

    private static List<String> mRestaurantDes = Arrays.asList(new String[]{"xxpizzahot", "kxxababi", "xxpasta"});

    private static List<List<Category>> mRestaurantCategoreis = new ArrayList<>();
    private static List<List<Food>> mRestaurantAllFoods = new ArrayList<>();
    private static List<Double> mRestaurantDeliveryPrice = Arrays.asList(new Double[]{2.5, 3.5, 4.5});
    private static List<Double> mRestaurantOff = Arrays.asList(new Double[]{20.0, 10.0, 30.0});
    private static List<String> mRestaurantImageAddress = Arrays.asList(new String[]{"xzzzxpizzahot", "kxxazzbabi", "xxpzzasta"});
    private static List<String> mRestaurantAddress = Arrays.asList(new String[]{"teh", "karaj", "shomal"});
    private static List<Restaurant.Partiation> mRestaurantKind = Arrays.asList(new Restaurant.Partiation[]{Restaurant.Partiation.REsturant, Restaurant.Partiation.Candy});


    static Bag currerntBAg;
    static List<Food> foods1 = new ArrayList<>();

    private StaticDataGenerator(Context context) {

        this.mContext = context;


        categoryinter();
        restaurantGenarator();


    }

    public static StaticDataGenerator getInstance(Context context) {
        if (instance == null)
            instance = new StaticDataGenerator(context);
        return instance;
    }


    public static List<Restaurant> restaurantGenarator() {
        ///


        //
        List<Restaurant> resList = new ArrayList<>();

        for (int i = 0; i < mRestaurantCategoreis.size(); i++) {
            Restaurant restaurant = new Restaurant(
                    mRestaurantId.get(i),
                    mRestaurantName.get(i),
                    mRestaurantRate.get(i),
                    mRestaurantOff.get(i),
                    mRestaurantDes.get(i),
                    mRestaurantAddress.get(i),
                    mRestaurantCategoreis.get(i),
                    mRestaurantAllFoods.get(i),
                    mRestaurantDeliveryPrice.get(i),
                    mRestaurantImageAddress.get(i),
                    mRestaurantKind.get(i));
            resList.add(i, restaurant);

        }
        return resList;
    }

    private static void categoryinter() {
        Category category1 = new Category("portarafdar", 1, "pizzahot", 12, foods1);
        Category category2 = new Category("tsetset", 2, "pizzahot", 12, foods1);
        List<Category> tempCategories = new ArrayList<>();
        tempCategories.add(0, category1);
        tempCategories.add(1, category2);
        mRestaurantCategoreis.add(0, (List<Category>) tempCategories);
        mRestaurantCategoreis.add(1, (List<Category>) tempCategories);
        Food food1 = new Food(1, "kabab", 12000, 0.0, 2, "no des", "pizzahot", category1.getmCategoryName(), "noImage");
        Food food2 = new Food(2, "joj", 12000, 0.0, 3, "bad maze af", "pizzahot", category1.getmCategoryName(), "noImage");

        foods1.add(0, food1);
        foods1.add(1, food2);
        mRestaurantAllFoods.add(0, foods1);
        mRestaurantAllFoods.add(1, foods1);

    }

    public static List<Restaurant> getmAllRestList() {
        return restaurantGenarator();
    }

    public static List<Restaurant> getSortedRestListAsRate() {
        List<Restaurant> basicList = restaurantGenarator();
        int n = basicList.size();
        Restaurant temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (basicList.get(j - 1).getmRestaurantRate() > basicList.get(j).getmRestaurantRate()) {
                    //swap elements
                    temp = basicList.get(j - 1);
                    //  arr[j-1] = arr[j];
                    basicList.set(j - 1, basicList.get(j));
                    basicList.set(j, temp);
                }
            }
        }
        return basicList;
    }
    public static List<Restaurant> getSortedRestListAsOffer() {
        List<Restaurant> basicList = restaurantGenarator();
        int n = basicList.size();
        Restaurant temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (basicList.get(j - 1).getmRestaurantOff() > basicList.get(j).getmRestaurantOff()) {
                    //swap elements
                    temp = basicList.get(j - 1);
                    //  arr[j-1] = arr[j];
                    basicList.set(j - 1, basicList.get(j));
                    basicList.set(j, temp);
                }
            }
        }
        return basicList;
    }

    public static Restaurant serarchRestById(int id) {

        for (int i = 0; i < restaurantGenarator().size(); i++) {
            if (restaurantGenarator().get(i).getmRestaurantId() == id)
                return restaurantGenarator().get(i);
        }
        Log.e("test", "resturanut ba in id yaft nashod");
        return null;

    }

    public static Category searchCategoryById(int mCategoryId) {
        for (int i = 0; i < mRestaurantCategoreis.size(); i++) {
            for (int j = 0; i < mRestaurantCategoreis.size(); j++) {
                if (mRestaurantCategoreis.get(i).get(j).getmCategoryId() == mCategoryId)
                    return mRestaurantCategoreis.get(i).get(j);
            }
        }
        Log.e("test", "category ba in id yaft nashod");
        return null;
    }

}
