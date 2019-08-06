package com.example.shayanmoradi.injastfood.model;

import android.content.Context;
import android.util.Log;

import com.example.shayanmoradi.injastfood.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StaticDataGenerator {

    private static StaticDataGenerator instance;

    private Context mContext;

    public static List<Restaurant> mAllRestList;
    private static List<Integer> mRestaurantId = Arrays.asList(new Integer[]{12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26});
    private static List<String> mRestaurantName = Arrays.asList(new String[]{"ایران فود", "نامی نو لند", "سیب ", "ایرانویچ", "هفت جنار", "کافه شین", "پیتزا دارت ", "بامداد", "سعید", "ابمیوه نعمت", "ایرانویچ"});
    private static List<Integer> mRestaurantRate = Arrays.asList(new Integer[]{1, 2, 3, 3, 2, 1, 2, 3, 1, 5, 5});

    private static List<String> mRestaurantDes = Arrays.asList(new String[]{"ایران فود", "نامی نو لند", "سیب ", "ایرانویچ", "ایران فود", "نامی نو لند", "سیب ", "ایرانویچ", "سنتی ", "کبابی", "فست فود", "ساندویج "});

    private static List<List<Category>> mRestaurantCategoreis = new ArrayList<>();
    private static List<List<Food>> mRestaurantAllFoods = new ArrayList<>();
    private static List<Double> mRestaurantDeliveryPrice = Arrays.asList(new Double[]{2500.0, 3500.0, 4500.0, 2000.0, 2500.0, 3500.0, 4500.0, 2000.0, 2500.0, 3500.0, 4500.0, 2000.0});
    private static List<Double> mRestaurantOff = Arrays.asList(new Double[]{20.0, 10.0, 30.0, 0.0, 40.0, 60.0, 30.0, 22.0, 0.0, 35.0});
    private static List<Integer> mRestaurantImageAddress = Arrays.asList(new Integer[]{
            R.drawable.f1,
            R.drawable.f2,
            R.drawable.f3,
            R.drawable.f4,
            R.drawable.f6,
            R.drawable.f5,
            R.drawable.f7,
            R.drawable.f8,
            R.drawable.f9,
            R.drawable.f10
    });
    private static List<Integer> mRestauranSecondtImageAddress = Arrays.asList(new Integer[]{
            R.drawable.r1,
            R.drawable.r2,
            R.drawable.r3,
            R.drawable.r4,
            R.drawable.r6,
            R.drawable.r5,
            R.drawable.r7,
            R.drawable.r8,
            R.drawable.r9,
            R.drawable.r10
    });

    private static List<String> mRestaurantAddress = Arrays.asList(new String[]{"پونک", "خیابان ازادی", "سعادت اباد", "تهران پارس", "پونک", "خیابان ازادی", "سعادت اباد", "تهران پارس", "پونک", "خیابان ازادی", "سعادت اباد", "تهران پارس"});
    private static List<Restaurant.Partiation> mRestaurantKind = Arrays.asList(new Restaurant.Partiation[]{Restaurant.Partiation.REsturant, Restaurant.Partiation.REsturant, Restaurant.Partiation.REsturant, Restaurant.Partiation.Candy, Restaurant.Partiation.Candy, Restaurant.Partiation.Caffe, Restaurant.Partiation.Caffe, Restaurant.Partiation.Others, Restaurant.Partiation.Candy});


    static Bag currerntBAg;
    static List<Food> foods1 = new ArrayList<>();
    static List<Food> foods2 = new ArrayList<>();
    static List<Food> foods3 = new ArrayList<>();
    static List<Food> foods4 = new ArrayList<>();
    static List<Food> foods5 = new ArrayList<>();
    static List<Food> foods6 = new ArrayList<>();
    static List<Food> foods7 = new ArrayList<>();


    public static boolean isFirst = true;
    public static String customerAddress = "نامشخش";


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
                    mRestauranSecondtImageAddress.get(i),
                    mRestaurantKind.get(i));
            resList.add(i, restaurant);

        }
        mAllRestList = resList;
        return resList;
    }

    private static void categoryinter() {
        Category category1 = new Category("پیتزا", 1, "پیتزا", 12, foods1);
        Category category2 = new Category("ساندویچ", 2, "ساندویچ", 12, foods2);

        Category category3 = new Category("کباب", 3, "کباب", 13, foods3);
        Category category4 = new Category(" برنجی", 4, "برنجی", 13, foods4);


        Category category5 = new Category("برنجی", 5, "برنجی", 14, foods5);
        Category category6 = new Category("فست فودی", 6, "فست فودی", 14, foods1);

        Category category7 = new Category("غیره ", 7, "غیره ", 14, foods2);
        Category category8 = new Category("پرطرفدار", 8, "شیرینی", 14, foods3);

        Category category9 = new Category("شیرینی ", 9, "غیره ", 14, foods6);
        Category category10 = new Category("غیره ", 10, "غیره ", 14, foods7);

        List<Category> tempCategories = new ArrayList<>();
        List<Category> tempCategories2 = new ArrayList<>();
        List<Category> tempCategories3 = new ArrayList<>();
        List<Category> tempCategories4 = new ArrayList<>();
        List<Category> tempCategories5 = new ArrayList<>();
        List<Category> tempCategories6 = new ArrayList<>();
        List<Category> tempCategories7 = new ArrayList<>();
        List<Category> tempCategories8 = new ArrayList<>();
        List<Category> tempCategories9 = new ArrayList<>();

        tempCategories.add(0, category1);
        tempCategories.add(1, category2);

        tempCategories2.add(0, category3);
        tempCategories2.add(1, category4);

        tempCategories3.add(0, category5);
        tempCategories3.add(1, category6);

        tempCategories4.add(0, category7);
        tempCategories4.add(1, category8);

        tempCategories5.add(0, category1);
        tempCategories5.add(1, category2);

        tempCategories6.add(0, category3);
        tempCategories6.add(1, category4);

        tempCategories7.add(0, category5);
        tempCategories7.add(1, category6);

        tempCategories8.add(0, category7);
        tempCategories8.add(1, category8);

        tempCategories9.add(0, category9);
        tempCategories9.add(1, category10);

        mRestaurantCategoreis.add(0, (List<Category>) tempCategories);
        mRestaurantCategoreis.add(1, (List<Category>) tempCategories2);
        mRestaurantCategoreis.add(2, (List<Category>) tempCategories3);
        mRestaurantCategoreis.add(3, (List<Category>) tempCategories4);
        mRestaurantCategoreis.add(4, (List<Category>) tempCategories5);
        mRestaurantCategoreis.add(5, (List<Category>) tempCategories6);
        mRestaurantCategoreis.add(6, (List<Category>) tempCategories7);
        mRestaurantCategoreis.add(7, (List<Category>) tempCategories8);
        mRestaurantCategoreis.add(8, (List<Category>) tempCategories9);

        Log.e("test", "     " + mRestaurantCategoreis.size());

        Food food1 = new Food(1, "قیمه بادمجون", 17000, 30.0, 2, "خانگی", "pizzahot", category1.getmCategoryName(), R.drawable.f1);
        Food food2 = new Food(2, "پیتز پپرونی", 250000, 20.0, 3, "تند", "pizzahot", category1.getmCategoryName(), R.drawable.f2);

        Food food3 = new Food(3, "زرشک پلو با مرغ", 18000, 15.0, 1, "ران مرغ", "pizzahot", category2.getmCategoryName(), R.drawable.f3);
        Food food4 = new Food(4, "نگینی", 27000, 0.0, 3, "همراه با برنج", "pizzahot", category2.getmCategoryName(), R.drawable.f4);


        Food food5 = new Food(5, "ساندویچ", 18000, 40.0, 4, "هات داگ", "kababi", category3.getmCategoryName(), R.drawable.f5);
        Food food6 = new Food(6, "کیک", 38000, 30.0, 3, "شکلاتی", "kababi", category3.getmCategoryName(), R.drawable.f6);

        Food food7 = new Food(7, "نان سیر", 12000, 0.0, 5, "پیش غذا", "kababi", category4.getmCategoryName(), R.drawable.f7);
        Food food8 = new Food(8, "سالاد", 8000, 20.0, 1, "سالاد فصل", "kababi", category4.getmCategoryName(), R.drawable.f8);

        ///
        Food food9 = new Food(9, "کوبیده", 25000, 0.0, 1, "دو یسخ", "kababi", category4.getmCategoryName(), R.drawable.f9);
        Food food10 = new Food(10, "نیمرو", 12000, 10.0, 5, "نیمرو با نان", "kababi", category4.getmCategoryName(), R.drawable.f10);

        Food food11 = new Food(11, "شیرینی زبان", 25000, 0.0, 1, "شیرینی", "kababi", category4.getmCategoryName(), R.drawable.c1);
        Food food12 = new Food(12, "رولت", 12000, 10.0, 5, "شیرینی", "kababi", category4.getmCategoryName(), R.drawable.c2);

        Food food13 = new Food(13, "نان خامه ایی", 25000, 0.0, 1, "شیرینی", "kababi", category4.getmCategoryName(), R.drawable.c3);
        Food food14 = new Food(14, "کیک", 12000, 10.0, 5, "شیرینی", "kababi", category4.getmCategoryName(), R.drawable.c4);

        foods1.add(0, food1);
        foods1.add(1, food2);

        foods2.add(0, food3);
        foods2.add(1, food4);

        foods3.add(0, food5);
        foods3.add(1, food6);

        foods4.add(0, food7);
        foods4.add(1, food8);

        foods5.add(0, food9);
        foods5.add(1, food10);

        foods5.add(0, food11);
        foods5.add(1, food12);

        foods6.add(0, food13);
        foods6.add(1, food14);

        foods7.add(0, food11);
        foods7.add(1, food12);

        mRestaurantAllFoods.add(0, foods1);
        mRestaurantAllFoods.add(1, foods2);
        mRestaurantAllFoods.add(2, foods3);
        mRestaurantAllFoods.add(3, foods4);
        mRestaurantAllFoods.add(4, foods4);
        mRestaurantAllFoods.add(5, foods4);
        mRestaurantAllFoods.add(6, foods4);
        mRestaurantAllFoods.add(7, foods4);
        mRestaurantAllFoods.add(8, foods5);
        mRestaurantAllFoods.add(9, foods5);
        mRestaurantAllFoods.add(10, foods6);
        mRestaurantAllFoods.add(11, foods7);


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

                    basicList.set(j - 1, basicList.get(j));
                    basicList.set(j, temp);
                }
            }
        }
        Collections.reverse(basicList);
        return basicList;
    }

    public static List<Restaurant> getSortedRestListAsOffer() {
        List<Restaurant> basicList = restaurantGenarator();
        for (int i = 0; i < basicList.size(); i++) {
            if (restaurantGenarator().get(i).getmRestaurantOff() == 0.0)
                basicList.remove(i);

        }

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
        Collections.reverse(basicList);
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

    public String getRestNameBydId(int restId) {
        for (int i = 0; i < mAllRestList.size(); i++) {
            if (mAllRestList.get(i).getmRestaurantId() == restId)
                return mAllRestList.get(i).getmRestaurantName();
        }

        return "not found";
    }
}


