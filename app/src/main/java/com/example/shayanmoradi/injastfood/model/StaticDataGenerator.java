package com.example.shayanmoradi.injastfood.model;

import java.util.Arrays;
import java.util.List;

public class StaticDataGenerator {





    private List<Integer> mRestaurantId =Arrays.asList(new Integer[]{12,13,14});
    private List<String> mRestaurantName= Arrays.asList(new String[]{"pizzahot","kababi","pasta"});
    private List<Integer> mRestaurantRate=Arrays.asList(new Integer[]{12,13,14});;
    private List<String> mRestaurantDes=Arrays.asList(new String[]{"xxpizzahot","kxxababi","xxpasta"});
    private List<List<Category>> mRestaurantCategoreis;
    private List<List<Food>> mRestaurantAllFoods;
    private List<Double> mRestaurantDeliveryPrice=Arrays.asList(new Double[]{12.5,13.4,14.5});
    private List<String> mRestaurantImageAddress=Arrays.asList(new String[]{"xzzzxpizzahot","kxxazzbabi","xxpzzasta"});;

    List<Food>foods1=null;




    public List<Restaurant> restaurantGenarator() {
        ///





        //
        List<Restaurant> resList=null;

        for (int i = 0; i < mRestaurantId.size(); i++) {
            Restaurant restaurant = new Restaurant(
                    mRestaurantId.get(i),
                    mRestaurantName.get(i),
                    mRestaurantRate.get(i),
                    mRestaurantDes.get(i),
                    mRestaurantCategoreis.get(i),
                    mRestaurantAllFoods.get(i),
                    mRestaurantDeliveryPrice.get(i),
                    mRestaurantImageAddress.get(i));
            resList.add(i,restaurant);

        }
        return resList;
    }
    private void categoryinter(){
        Category category1= new Category("portarafdar",1,"pizzahot",12,foods1);
        Category category2= new Category("tsetset",2,"pizzahot",12,foods1);
         Food food1=new Food(1,"kabab",12000,0.0,3,"pizzahot",category1.getmCategoryName(),"noImage");
         Food food2=new Food(1,"joj",12000,0.0,3,"pizzahot",category1.getmCategoryName(),"noImage");

        foods1.add(0,food1);
        foods1.add(1,food2);


    }




}
