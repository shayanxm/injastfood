package com.example.shayanmoradi.injastfood.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaticDataGenerator {

    private static StaticDataGenerator instance;

    private Context mContext;

public static List<Restaurant> mAllRestList;
    private static List<Integer> mRestaurantId = Arrays.asList(new Integer[]{12, 13, 14});
    private static List<String> mRestaurantName = Arrays.asList(new String[]{"pizzahot", "kababi", "pasta"});
    private static List<Integer> mRestaurantRate = Arrays.asList(new Integer[]{12, 13, 14});

    private static List<String> mRestaurantDes = Arrays.asList(new String[]{"xxpizzahot", "kxxababi", "xxpasta"});

    private static  List<List<Category>> mRestaurantCategoreis=new ArrayList<>();
    private static List<List<Food>> mRestaurantAllFoods= new ArrayList<>();
    private static List<Double> mRestaurantDeliveryPrice = Arrays.asList(new Double[]{12.5, 13.4, 14.5});
    private static List<String> mRestaurantImageAddress = Arrays.asList(new String[]{"xzzzxpizzahot", "kxxazzbabi", "xxpzzasta"});
    private static List<String> mRestaurantAddress = Arrays.asList(new String[]{"teh", "karaj", "shomal"});
    private static List<Restaurant.Partiation>mRestaurantKind=Arrays.asList(new Restaurant.Partiation[]{Restaurant.Partiation.REsturant,Restaurant.Partiation.Candy});

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
        Food food1 = new Food(1, "kabab", 12000, 0.0, 3, "pizzahot", category1.getmCategoryName(), "noImage");
        Food food2 = new Food(1, "joj", 12000, 0.0, 3, "pizzahot", category1.getmCategoryName(), "noImage");

        foods1.add(0, food1);
        foods1.add(1, food2);
        mRestaurantAllFoods.add(0, foods1);
        mRestaurantAllFoods.add(1, foods1);

    }

    public static List<Restaurant> getmAllRestList() {
        return restaurantGenarator();
    }
}
