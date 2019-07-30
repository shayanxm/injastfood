package com.example.shayanmoradi.injastfood.view.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.shayanmoradi.injastfood.R;
import com.example.shayanmoradi.injastfood.model.Restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ShowListOfRestActivity extends AppCompatActivity {
    public static final String kindCode = "com.example.shayanmoradi.injastfood.view.list.kindcode";
    public static final String searchString = "com.example.shayanmoradi.injastfood.view.list.search.string";
    public static int whatInfoInt = -1;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ShowListOfRestActivity.class);
        whatInfoInt = 0;
        return intent;
    }

    public static Intent newIntent(Context context, Restaurant.Partiation partiation) {
        Intent intent = new Intent(context, ShowListOfRestActivity.class);
        whatInfoInt = 1;

        int kindInInt = -1;
        switch (partiation) {
            case REsturant:
                kindInInt = 0;
                intent.putExtra(kindCode, kindInInt);

                break;
            case Candy:
                kindInInt = 1;
                intent.putExtra(kindCode, kindInInt);
                break;
            case Caffe:
                kindInInt = 2;
                intent.putExtra(kindCode, kindInInt);

                break;
            case Others:
                kindInInt = 3;
                intent.putExtra(kindCode, kindInInt);

                break;
        }


        return intent;
    }

    public static Intent newIntent(Context context, String search) {
        whatInfoInt = 2;
        Intent intent = new Intent(context, ShowListOfRestActivity.class);
        intent.putExtra(searchString, search);

        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_of_rest);


        //   Fragment fragment = ShowListOfRestFragment.newInstance();


//        ShowListOfRestFragment.newInstance();
//        ShowListOfRestFragment.newInstance("test");

        Fragment fragment;
        switch (whatInfoInt) {
            case 0:
                fragment = ShowListOfRestFragment.newInstance();
                break;
            case 1:
             int partiation = (Integer) getIntent().getSerializableExtra(kindCode);
                fragment = ShowListOfRestFragment.newInstance(partiation);
                break;
            case 2:
                fragment = ShowListOfRestFragment.newInstance("test");
                break;
            default:
                fragment = ShowListOfRestFragment.newInstance();
                Log.e("list","unvalid page to go");
        }

        getSupportFragmentManager()
                .beginTransaction()

                .replace(R.id.list_continer, fragment)
                .commit();
    }
}
