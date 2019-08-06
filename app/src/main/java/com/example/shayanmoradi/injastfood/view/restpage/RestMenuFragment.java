package com.example.shayanmoradi.injastfood.view.restpage;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shayanmoradi.injastfood.R;
import com.example.shayanmoradi.injastfood.model.Category;
import com.example.shayanmoradi.injastfood.model.Restaurant;
import com.example.shayanmoradi.injastfood.model.StaticDataGenerator;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import static com.example.shayanmoradi.injastfood.view.restpage.RestPageActivity.restID;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestMenuFragment extends androidx.fragment.app.Fragment {
    public static final String CategoryId = "com.example.shayanmoradi.injastfood.view.restpage.categoryId";
    private TabLayout tabLayout;
    ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    int resturauntID;
    Restaurant currentRest;
    List<Category> thisRestCategories = new ArrayList<>();
    private ViewPagerAdapter viewPagerAdapter1;

    public static RestMenuFragment newInstance(int restIntId) {

        Bundle args = new Bundle();
        args.putSerializable(restID, restIntId);

        RestMenuFragment fragment = new RestMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public RestMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resturauntID = (Integer) getArguments().getSerializable(restID);
        Log.e("test,", resturauntID + "");
        currentRest = StaticDataGenerator.getInstance(getActivity()).serarchRestById(resturauntID);
        thisRestCategories = currentRest.getmRestaurantCategoreis();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rest_menu, container, false);

        setUpViewByIds(view);

        setUpViewPager();

        return view;
    }

    private void setUpViewPager() {
        tabLayout.setupWithViewPager(viewPager);

        viewPagerAdapter = new ViewPagerAdapter(this.getChildFragmentManager());

        for (int i = 0; i < thisRestCategories.size(); i++) {
            RestUnderMenuFragment tabLayoutFragment = RestUnderMenuFragment.newInstance(thisRestCategories.get(i).getmCategoryId());
            viewPagerAdapter.addFrag(tabLayoutFragment, thisRestCategories.get(i).getmCategoryName());
        }

        viewPager.setAdapter(viewPagerAdapter);

        viewPager.setCurrentItem(1);
    }

    private void setUpViewByIds(View view) {
        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.viewPager);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<androidx.fragment.app.Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public androidx.fragment.app.Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(androidx.fragment.app.Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }
}
