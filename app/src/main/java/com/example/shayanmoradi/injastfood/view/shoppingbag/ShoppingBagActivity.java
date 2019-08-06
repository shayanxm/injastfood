package com.example.shayanmoradi.injastfood.view.shoppingbag;

import android.os.Bundle;

import com.example.shayanmoradi.injastfood.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ShoppingBagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_bag);


        Fragment fragment = ShoppingBagFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()

                .replace(R.id.shopping_bag_continer, fragment)
                .commit();
    }
}
