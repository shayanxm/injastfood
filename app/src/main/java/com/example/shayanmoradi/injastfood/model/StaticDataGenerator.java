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
    private static List<Integer> mRestaurantId = Arrays.asList(new Integer[]{12, 13, 14, 15});
    private static List<String> mRestaurantName = Arrays.asList(new String[]{"pizzahot", "kababi", "pasta food", "azhdar zapata"});
    private static List<Integer> mRestaurantRate = Arrays.asList(new Integer[]{3, 2, 4, 2});

    private static List<String> mRestaurantDes = Arrays.asList(new String[]{"xxpizzahot", "kxxababi", "xxpasta", "ghool sandwitch"});

    private static List<List<Category>> mRestaurantCategoreis = new ArrayList<>();
    private static List<List<Food>> mRestaurantAllFoods = new ArrayList<>();
    private static List<Double> mRestaurantDeliveryPrice = Arrays.asList(new Double[]{2500.0, 3500.0, 4500.0, 2000.0});
    private static List<Double> mRestaurantOff = Arrays.asList(new Double[]{20.0, 10.0, 30.0, 0.0});
    private static List<String> mRestaurantImageAddress = Arrays.asList(new String[]{"ponak", "kxxazzbabi", "xxpzzasta", ""});
    private static List<String> mRestaurantAddress = Arrays.asList(new String[]{"ponak", "satari", "kaj", "azadi"});
    private static List<Restaurant.Partiation> mRestaurantKind = Arrays.asList(new Restaurant.Partiation[]{Restaurant.Partiation.REsturant, Restaurant.Partiation.Candy, Restaurant.Partiation.Caffe, Restaurant.Partiation.Others});


    static Bag currerntBAg;
    static List<Food> foods1 = new ArrayList<>();
    static List<Food> foods2 = new ArrayList<>();
    static List<Food> foods3 = new ArrayList<>();
    static List<Food> foods4 = new ArrayList<>();

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
        Category category1 = new Category("bernji", 1, "pizzahot", 12, foods1);
        Category category2 = new Category("fast foods", 2, "pizzahot", 12, foods2);

        Category category3 = new Category("portarafdar", 3, "kababi", 13, foods2);
        Category category4 = new Category("fast foods", 4, "kababi", 13, foods2);


        Category category5 = new Category("portarafdar", 5, "pasta food", 14, foods2);
        Category category6 = new Category("fast foods", 6, "pasta food", 14, foods2);

        Category category7 = new Category("portarafdar", 7, "pasta food", 14, foods2);
        Category category8 = new Category("fast foods", 8, "pasta food", 14, foods2);

        List<Category> tempCategories = new ArrayList<>();
        List<Category> tempCategories2 = new ArrayList<>();
        List<Category> tempCategories3 = new ArrayList<>();
        List<Category> tempCategories4 = new ArrayList<>();

        tempCategories.add(0, category1);
        tempCategories.add(1, category2);

        tempCategories2.add(0, category3);
        tempCategories2.add(1, category4);

        tempCategories3.add(0, category5);
        tempCategories3.add(1, category6);

        tempCategories4.add(0, category7);
        tempCategories4.add(1, category8);

        mRestaurantCategoreis.add(0, (List<Category>) tempCategories);
        mRestaurantCategoreis.add(1, (List<Category>) tempCategories2);
        mRestaurantCategoreis.add(2, (List<Category>) tempCategories3);
        mRestaurantCategoreis.add(3, (List<Category>) tempCategories4);
        Log.e("wtf", "     " + mRestaurantCategoreis.size());

        Food food1 = new Food(1, "kabab", 12000, 0.0, 2, "no des", "pizzahot", category1.getmCategoryName(), "noImage");
        Food food2 = new Food(2, "joj", 12000, 0.0, 3, "bad maze af", "pizzahot", category1.getmCategoryName(), "noImage");

        Food food3 = new Food(3, "pitza", 12000, 0.0, 2, "no des", "pizzahot", category2.getmCategoryName(), "noImage");
        Food food4 = new Food(4, "sandwitch", 12000, 0.0, 3, "bad maze af", "pizzahot", category2.getmCategoryName(), "noImage");


        Food food5 = new Food(5, "1", 12000, 0.0, 2, "no des", "kababi", category3.getmCategoryName(), "noImage");
        Food food6 = new Food(6, "2", 12000, 0.0, 3, "bad maze af", "kababi", category3.getmCategoryName(), "noImage");

        Food food7 = new Food(7, "3", 12000, 0.0, 2, "no des", "kababi", category4.getmCategoryName(), "noImage");
        Food food8 = new Food(8, "4", 12000, 0.0, 3, "bad maze af", "kababi", category4.getmCategoryName(), "noImage");


        foods1.add(0, food1);
        foods1.add(1, food2);
        foods2.add(0, food3);
        foods2.add(1, food4);

        foods3.add(0, food5);
        foods3.add(1, food6);
        foods4.add(0, food7);
        foods4.add(1, food8);

        mRestaurantAllFoods.add(0, foods1);

        mRestaurantAllFoods.add(1, foods2);
        mRestaurantAllFoods.add(2, foods3);

        mRestaurantAllFoods.add(3, foods4);

        mRestaurantAllFoods.add(4, foods4);
        mRestaurantAllFoods.add(5, foods4);
        mRestaurantAllFoods.add(6, foods4);
        mRestaurantAllFoods.add(7, foods4);


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
            for (int j = 0; j < mRestaurantCategoreis.get(i).size(); j++) {
                if (mRestaurantCategoreis.get(i).get(j).getmCategoryId() == mCategoryId)
                    return mRestaurantCategoreis.get(i).get(j);
            }
        }
        Log.e("test", "category ba in id yaft nashod");
        return null;
    }




}
