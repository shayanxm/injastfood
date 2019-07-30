package com.example.shayanmoradi.injastfood.view.menu;

import android.os.Bundle;

import com.example.shayanmoradi.injastfood.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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
