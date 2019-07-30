package com.example.shayanmoradi.injastfood.view.list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.shayanmoradi.injastfood.R;

public class ShowListOfRestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_of_rest);



        Fragment fragment = ShowListOfRestFragment.newInstance();


        getSupportFragmentManager()
                .beginTransaction()

                .replace(R.id.list_continer, fragment)
                .commit();
    }
}
