package com.example.shayanmoradi.injastfood.view.restpage;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shayanmoradi.injastfood.R;

import androidx.annotation.Nullable;

/**
 * A simple {@link Fragment} subclass.
 */
public class CmAndCoupsFragment extends androidx.fragment.app.Fragment {
    public static final String whatToShowCode = "com.example.shayanmoradi.injastfood.view.restpage.pageCode";
    private int pageCode;
    private TextView txtToShowTv;

    public static CmAndCoupsFragment newInstance(int pageCode) {

        Bundle args = new Bundle();
        args.putSerializable(whatToShowCode, pageCode);

        CmAndCoupsFragment fragment = new CmAndCoupsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public CmAndCoupsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageCode = (Integer) getArguments().getSerializable(whatToShowCode);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cm_and_coups, container, false);
        txtToShowTv = view.findViewById(R.id.no_active_tv);
        if (pageCode == 0) {
            txtToShowTv.setText("در حال حاضر هیج کوپنی برای این رسوران فعال نیست");
        }else
            txtToShowTv.setText("در حال حاضر نظری برای این رستوران ثبت نشده");
        return view;
    }

}
