package com.example.shayanmoradi.injastfood.view.restpage;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shayanmoradi.injastfood.R;

public class RestPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_page);

        Fragment fragment = RestPageFragment.newInstance();


        getSupportFragmentManager()
                .beginTransaction()

                .replace(R.id.rest_page_continer, fragment)
                .commit();
    }
}
