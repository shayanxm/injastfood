package com.example.shayanmoradi.injastfood.model;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private static Bag instance;
    static boolean empty = true;

    private static int mbagRestaurantId;
    private static String mbagId;
    private static List<Food> mfoodsInBag = new ArrayList<>();
    private static List<Food> mFoodsInBagUnic = new ArrayList<>();
    private static List<Integer> mFoodCount = new ArrayList<>();
    private int allFodCount = 0;


    Context mContext;

    private Bag(Context context) {

        this.mContext = context;

    }

    public static Bag getInstance(Context context) {
        if (instance == null)
            instance = new Bag(context);
        return instance;
    }

    public static void emptizeTheBag(Context context) {
        // instance = new Bag(context);
        for (int i = 0; i < mfoodsInBag.size(); i++) {
            mfoodsInBag.get(i).setmFoodInBagCount(0);
        }
        mfoodsInBag = new ArrayList<>();
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void setMbagRestaurantId(int mbagRestaurantId) {
        this.mbagRestaurantId = mbagRestaurantId;
    }

    public void setMbagId(String mbagId) {
        this.mbagId = mbagId;
    }

    public void setMfoodsInBag(List<Food> mfoodsInBag) {
        this.mfoodsInBag = mfoodsInBag;
    }

    public boolean isEmpty() {
        return empty;
    }

    public int getMbagRestaurantId() {
        return mbagRestaurantId;
    }

    public String getMbagId() {
        return mbagId;
    }

    public List<Food> getMfoodsInBag() {
        unicListAndCounter();
        return mfoodsInBag;
    }

    public static Bag getInstance() {
        return instance;
    }

    public static void setInstance(Bag instance) {
        Bag.instance = instance;
    }

    public static void addToBag(Food food) {
        boolean newOrNot = true;
        for (int i = 0; i < mfoodsInBag.size(); i++) {
            if (mfoodsInBag.get(i).getMfoodId() == food.getMfoodId()) {

                mfoodsInBag.get(i).setmFoodInBagCount(mfoodsInBag.get(i).getmFoodInBagCount() + 1);
                return;
            }


            //   if (otherRestBagCheck())
        }
        food.setmFoodInBagCount(1);
        mfoodsInBag.add(mfoodsInBag.size(), food);


    }

    public static void removeZeroCount() {
        for (int i = 0; i < mfoodsInBag.size(); i++) {
            if (mfoodsInBag.get(i).getmFoodInBagCount() == 0) {
                mfoodsInBag.remove(i);

            }
        }
    }

    public static void removeFromBag(Food food) {
        //   if (otherRestBagCheck())
        if (food.getmFoodInBagCount() == 0) {
            mfoodsInBag.remove(food);
            return;
        }
        boolean works = false;
        for (int i = 0; i < mfoodsInBag.size(); i++) {
            if (mfoodsInBag.get(i).getMfoodId() == food.getMfoodId()) {
                //mfoodsInBag.remove(i);
                mfoodsInBag.get(i).setmFoodInBagCount(mfoodsInBag.get(i).getmFoodInBagCount() - 1);
                works = true;
            }
        }
        if (!works)
            Log.e("test", "peyda nashod");


    }

    public static boolean otherRestBagCheck() {
        for (int i = 0; i < mfoodsInBag.size(); i++) {
            for (int j = 0; i < mfoodsInBag.size(); j++) {
                if (mfoodsInBag.get(i).getMfoodRestaurantName() == mfoodsInBag.get(j).getMfoodRestaurantName())
                    Log.e("test", "sefaresh faal az rest digr");
                return false;
            }
        }
        return true;
    }

    public static void unicListAndCounter() {
        //if (mFoodsInBagUnic.size() == 0)
        mFoodsInBagUnic = new ArrayList<>(mfoodsInBag);
        for (int i = 0; i < mFoodsInBagUnic.size(); i++) {
            for (int j = 0; j < mFoodsInBagUnic.size(); j++) {
                if (mFoodsInBagUnic.get(i).getMfoodId() == mFoodsInBagUnic.get(j).getMfoodId()) {
                    if (i != j) {
                        int temp = mFoodsInBagUnic.get(i).getmFoodInBagCount();
                        temp++;
                        mFoodsInBagUnic.get(i).setmFoodInBagCount(temp);
                        mFoodsInBagUnic.remove(j);
                    }
                }
            }
        }
        // removeRepet();

    }

    public static List<Food> getmFoodsInBagUnic() {
        unicListAndCounter();
        return mFoodsInBagUnic;
    }

    private static void removeRepet() {
        for (int i = 0; i < mFoodsInBagUnic.size(); i++) {

            for (int j = 0; j < mFoodsInBagUnic.size(); j++) {
                if (i != j) {
                    if (mFoodsInBagUnic.get(i).getMfoodId() == mFoodsInBagUnic.get(j).getMfoodId())
                        mFoodsInBagUnic.remove(j);
                }
            }
        }
    }

    public static int totalPriaceCalculater() {

        int temp = 0;
        for (int i = 0; i < mfoodsInBag.size(); i++) {
            int offeredPrice = (int) (mfoodsInBag.get(i).getMfoodPrice() - mfoodsInBag.get(i).getMfoodPrice() * mfoodsInBag.get(i).getMfoodOff() / 100);
            temp += offeredPrice * mfoodsInBag.get(i).getmFoodInBagCount();
        }
        return temp;
    }

    public static int getAllCount() {
        int temp = 0;
        for (int i = 0; i < mfoodsInBag.size(); i++) {
            int count = mfoodsInBag.get(i).getmFoodInBagCount();
            temp += count;

        }
        return temp;
    }


}

