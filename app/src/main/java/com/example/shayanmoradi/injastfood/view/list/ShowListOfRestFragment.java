package com.example.shayanmoradi.injastfood.view.list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shayanmoradi.injastfood.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowListOfRestFragment extends Fragment {
    public static ShowListOfRestFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ShowListOfRestFragment fragment = new ShowListOfRestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ShowListOfRestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_show_list_of_rest, container, false);
   return view;
   
    }

}
