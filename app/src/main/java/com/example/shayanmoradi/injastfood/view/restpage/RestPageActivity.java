package com.example.shayanmoradi.injastfood.view.restpage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.shayanmoradi.injastfood.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class RestPageActivity extends AppCompatActivity {
    public static final String restID = "com.example.shayanmoradi.injastfood.view.restpage.restID";

    public static Intent newIntent(Context context, int restIntId) {

        Intent intent = new Intent(context, RestPageActivity.class);
        intent.putExtra(restID, restIntId);

        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_page);


        int partiation = (Integer) getIntent().getSerializableExtra(restID);

        Fragment fragment = RestPageFragment.newInstance(partiation);

        getSupportFragmentManager()
                .beginTransaction()

                .replace(R.id.rest_page_continer, fragment)
                .commit();
    }
}
