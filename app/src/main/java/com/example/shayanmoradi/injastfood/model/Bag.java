package com.example.shayanmoradi.injastfood.model;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private static Bag instance;
    static boolean empty = true;

    private static String mbagRestaurantId;
    private static String mbagId;
    private static List<Food> mfoodsInBag=new ArrayList<>();
    Context mContext;

    private Bag(Context context) {

        this.mContext = context;

    }

    public static Bag getInstance(Context context) {
        if (instance == null)
            instance = new Bag(context);
        return instance;
    }


    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void setMbagRestaurantId(String mbagRestaurantId) {
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

    public String getMbagRestaurantId() {
        return mbagRestaurantId;
    }

    public String getMbagId() {
        return mbagId;
    }

    public List<Food> getMfoodsInBag() {
        return mfoodsInBag;
    }

    public static Bag getInstance() {
        return instance;
    }

    public static void setInstance(Bag instance) {
        Bag.instance = instance;
    }

    public static void addToBag(Food food) {
     //   if (otherRestBagCheck())
        mfoodsInBag.add(mfoodsInBag.size(), food);

    }
    public static void removeFromBag(Food food) {
        //   if (otherRestBagCheck())
        if (mfoodsInBag.size()==0)return;
        boolean works=false;
        for (int i=0;i<mfoodsInBag.size();i++){
            if (mfoodsInBag.get(i).getMfoodId()==food.getMfoodId()){
                mfoodsInBag.remove(food);
            works=true;}
        }if (!works)
        Log.e("test","peyda nashod");


    }

    public static boolean otherRestBagCheck() {
        for (int i = 0; i < mfoodsInBag.size(); i++) {
            for (int j = 0; i < mfoodsInBag.size(); j++){
                if (mfoodsInBag.get(i).getMfoodRestaurantName()==mfoodsInBag.get(j).getMfoodRestaurantName())
                    Log.e("test","sefaresh faal az rest digr");
                    return false;
            }
        }
return true;
    }

}

