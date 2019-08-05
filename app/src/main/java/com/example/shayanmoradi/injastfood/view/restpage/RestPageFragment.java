package com.example.shayanmoradi.injastfood.view.restpage;


import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shayanmoradi.injastfood.R;
import com.example.shayanmoradi.injastfood.model.Restaurant;
import com.example.shayanmoradi.injastfood.model.StaticDataGenerator;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import static com.example.shayanmoradi.injastfood.view.restpage.RestPageActivity.restID;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestPageFragment extends Fragment {
    private TextView restNameTv;
    private ImageView restImgIV;
    private TextView restDelPrice;
    private TabLayout tabLayout;
    TextView customerAddTv;
    ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    int resturauntID;
    Restaurant currentRest;

    public static RestPageFragment newInstance(int restIntId) {

        Bundle args = new Bundle();
        args.putSerializable(restID, restIntId);

        RestPageFragment fragment = new RestPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public RestPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resturauntID = (Integer) getArguments().getSerializable(restID);
        Log.e("test,", resturauntID + "");
        currentRest = StaticDataGenerator.getInstance(getActivity()).serarchRestById(resturauntID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_rest_page, container, false);
        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.viewPager);
        restNameTv = view.findViewById(R.id.rest_name_tv);
        restDelPrice = view.findViewById(R.id.rest_del_price_tv);
        restImgIV = view.findViewById(R.id.rest_img_iv);

         customerAddTv  =view.findViewById(R.id.customer_add_tv);
        customerAddTv.setText(StaticDataGenerator.customerAddress);
        customerAddTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertEditTextKeyboardShown();
            }
        });
        restNameTv.setText(currentRest.getmRestaurantName());
        restDelPrice.setText((int)currentRest.getmRestaurantDeliveryPrice() + " تومان ");
        restImgIV.setImageResource(currentRest.getmRestaurantSecondImageAddress());
        ImageView backIv = view.findViewById(R.id.imageView4);
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        ImageView mailIv = view.findViewById(R.id.imageView6);
        mailIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "در حال حاضر پیامی وجود ندارد", Toast.LENGTH_LONG).show();
            }
        });

        tabLayout.setupWithViewPager(viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        //viewPagerAdapter = new ViewPagerAdapter(this.getChildFragmentManager());
        RestMenuFragment tabLayoutFragment = RestMenuFragment.newInstance(resturauntID);
        CmAndCoupsFragment tabLayoutFragment1 = CmAndCoupsFragment.newInstance(0);
        CmAndCoupsFragment tabLayoutFragment2 = CmAndCoupsFragment.newInstance(1);


        viewPagerAdapter.addFrag(tabLayoutFragment1, "کوپن");
        viewPagerAdapter.addFrag(tabLayoutFragment2, "نظرات");
        viewPagerAdapter.addFrag(tabLayoutFragment, "منو");

        //viewPagerAdapter.addFrag(tabLayoutFragment, "نظرات");
        // viewPagerAdapter.addFrag(tabLayoutFragment, "کوپن");
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.setCurrentItem(2);


        return view;
    }


    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }
    public void alertEditTextKeyboardShown() {

        // creating the EditText widget programatically
        final EditText editText = new EditText(getActivity());

        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setMessage("ادرس خود را وارد کنید")

                // .setTitle("تعیین ادرس")
                .setView(editText)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        StaticDataGenerator.customerAddress=editText.getText().toString();
                        customerAddTv.setText(StaticDataGenerator.customerAddress);
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText
        // this part will make the soft keyboard automaticall visible
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }

}
