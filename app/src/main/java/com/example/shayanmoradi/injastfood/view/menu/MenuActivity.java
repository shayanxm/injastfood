package com.example.shayanmoradi.injastfood.view.menu;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shayanmoradi.injastfood.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Fragment fragment = MenuFragment.newInstance();


        getSupportFragmentManager()
                .beginTransaction()

                .replace(R.id.menu_continer, fragment)
                .commit();


    }
}
