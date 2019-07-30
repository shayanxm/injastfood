package com.example.shayanmoradi.injastfood.view.restpage;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shayanmoradi.injastfood.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestPageFragment extends Fragment {

    public static RestPageFragment newInstance() {
        
        Bundle args = new Bundle();
        
        RestPageFragment fragment = new RestPageFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public RestPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_rest_page, container, false);
   return view;
    }

}
