package com.example.shayanmoradi.injastfood.view.menu;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shayanmoradi.injastfood.R;
import com.example.shayanmoradi.injastfood.model.Restaurant;
import com.example.shayanmoradi.injastfood.model.StaticDataGenerator;
import com.example.shayanmoradi.injastfood.view.list.ShowListOfRestActivity;
import com.example.shayanmoradi.injastfood.view.restpage.RestPageActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private CardView goToAllBtn;
    private ConstraintLayout goToREstBtn;
    private ConstraintLayout goToCandyBtn;
    private ConstraintLayout goToCaffeBtn;
    private ConstraintLayout goTOOthersBtn;
    List<Restaurant> allRestList;
    List<Restaurant> restOrderAsRate;
    List<Restaurant> restOrderASOffer;
    Restaurant testRest;
    RecyclerView topRestRv;
    RecyclerView offerRestRv;
    TextView customerAddTv;
    ScrollView scrollView;

    public static MenuFragment newInstance() {

        Bundle args = new Bundle();

        MenuFragment fragment = new MenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        customerAddTv.setText(StaticDataGenerator.customerAddress);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        goToAllBtn = view.findViewById(R.id.go_to_all_rest_btn);

        goToREstBtn = view.findViewById(R.id.go_to_rest_cl);
        goToCandyBtn = view.findViewById(R.id.go_to_candy_cl);
        goToCaffeBtn = view.findViewById(R.id.go_to_caffe_cl);
        goTOOthersBtn = view.findViewById(R.id.go_to_others_cl);
        topRestRv = view.findViewById(R.id.top_foods_rv);
        offerRestRv = view.findViewById(R.id.offer_foods_rv);
        scrollView=view.findViewById(R.id.menu_scroll_view);
   customerAddTv  =view.findViewById(R.id.customer_add_tv);
   customerAddTv.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           alertEditTextKeyboardShown();
       }
   });

        if (StaticDataGenerator.isFirst)
            alertEditTextKeyboardShown();
        StaticDataGenerator.isFirst = false;
        ImageView mailIv = view.findViewById(R.id.imageView6);
        mailIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "در حال حاضر پیامی وجود ندارد", Toast.LENGTH_LONG).show();
            }
        });

        ImageView menu = view.findViewById(R.id.imageView4);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "developed by shayan moradi", Toast.LENGTH_SHORT).show();
            }
        });


        restOrderAsRate = StaticDataGenerator.getInstance(getActivity()).getSortedRestListAsRate();
        restOrderASOffer = StaticDataGenerator.getInstance(getActivity()).getSortedRestListAsOffer();

        topRestRv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL, false));
        TaskAdapter tasksAdapter = new TaskAdapter(restOrderAsRate);

        topRestRv.setAdapter(tasksAdapter);

        offerRestRv.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.HORIZONTAL, false));
        TaskAdapter2 offersAdapter = new TaskAdapter2(restOrderASOffer);
        offerRestRv.setAdapter(offersAdapter);


        goToAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ShowListOfRestActivity.newIntent(getActivity());

//      Intent intent= new Intent(getActivity(),RestPageActivity.class);
                startActivity(intent);

            }
        });
        goToREstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ShowListOfRestActivity.newIntent(getActivity(), Restaurant.Partiation.REsturant);
                //   Intent intent= ShowListOfRestActivity.newIntent(getActivity());
                startActivity(intent);

            }
        });
        goToCandyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ShowListOfRestActivity.newIntent(getActivity(), Restaurant.Partiation.Candy);
                //   Intent intent= ShowListOfRestActivity.newIntent(getActivity());
                startActivity(intent);

            }
        });
        goToCaffeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ShowListOfRestActivity.newIntent(getActivity(), Restaurant.Partiation.Caffe);
                //   Intent intent= ShowListOfRestActivity.newIntent(getActivity());
                startActivity(intent);

            }
        });
        goTOOthersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ShowListOfRestActivity.newIntent(getActivity(), Restaurant.Partiation.Others);
                //   Intent intent= ShowListOfRestActivity.newIntent(getActivity());
                startActivity(intent);

            }
        });


        return view;

    }

    class TaskHolder extends RecyclerView.ViewHolder {
        private TextView restNameTv;
        private TextView restDesTv;
        private TextView restAddTv;
        private TextView restDelMoneyTv;
        private ImageView restImg;
        private Restaurant mRestaurant;
        private TextView restRateTv;
        private TextView restOfferTv;
        int postion = 0;

        public TaskHolder(@NonNull final View itemView) {
            super(itemView);


            //
            // KindNameTv = itemView.findViewById(R.id.kind_name_tv);
            restNameTv = itemView.findViewById(R.id.items_name_top);
            restDesTv = itemView.findViewById(R.id.items_des_top);
            restAddTv = itemView.findViewById(R.id.items_add_top);
            restDelMoneyTv = itemView.findViewById(R.id.items_del_price_top);
            restImg = itemView.findViewById(R.id.items_image_top);


            restRateTv = itemView.findViewById(R.id.items_rate_top);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    //    mTask.setYesForEditNoForCreate(false);
                    itemView.getContext();

                    Intent intent = RestPageActivity.newIntent(getActivity(), mRestaurant.getmRestaurantId());

                    startActivity(intent);

//                    FragmentManager fragmentManager = getFragmentManager();
//                    TaskDetailFragment detailFragment = TaskDetailFragment.newInstance(mTask.getmTaskId());
//                    detailFragment.show(fragmentManager, "dialog");

                }
            });
        }

        public void bind(Restaurant restaurant) {
            mRestaurant = restaurant;

            ////
            //      set view up here
            ////

            restNameTv.setText(restaurant.getmRestaurantName());
            restDesTv.setText(restaurant.getmRestaurantDes());
            restAddTv.setText(restaurant.getmRestaurantAddress());
            restDelMoneyTv.setText((int) restaurant.getmRestaurantDeliveryPrice() + " تومان");
            restImg.setImageResource(restaurant.getmRestaurantImageAddress());
            double temp = restaurant.getmRestaurantRate();
            restRateTv.setText(temp + "");


        }


    }

    class TaskHolder2 extends RecyclerView.ViewHolder {
        private TextView restNameTv;
        private TextView restDesTv;
        private TextView restAddTv;
        private TextView restDelMoneyTv;
        private ImageView restImg;
        private Restaurant mRestaurant;
        private TextView restRateTv;
        private TextView restOfferTv;
        int postion = 0;

        public TaskHolder2(@NonNull final View itemView) {
            super(itemView);


            //
            // KindNameTv = itemView.findViewById(R.id.kind_name_tv);
            restNameTv = itemView.findViewById(R.id.items_name_top);
            restDesTv = itemView.findViewById(R.id.items_des_top);
            restAddTv = itemView.findViewById(R.id.items_add_top);
            // restDelMoneyTv = itemView.findViewById(R.id.items_del_price_top);
            restImg = itemView.findViewById(R.id.items_image_top);


            restOfferTv = itemView.findViewById(R.id.items_offer_top);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    //    mTask.setYesForEditNoForCreate(false);
                    itemView.getContext();

                    Intent intent = RestPageActivity.newIntent(getActivity(), mRestaurant.getmRestaurantId());

                    startActivity(intent);

//                    FragmentManager fragmentManager = getFragmentManager();
//                    TaskDetailFragment detailFragment = TaskDetailFragment.newInstance(mTask.getmTaskId());
//                    detailFragment.show(fragmentManager, "dialog");

                }
            });
        }

        public void bind(Restaurant restaurant) {
            mRestaurant = restaurant;

            ////
            //      set view up here
            ////

            restNameTv.setText(restaurant.getmRestaurantName());
            restDesTv.setText(restaurant.getmRestaurantDes());
            restAddTv.setText(restaurant.getmRestaurantAddress());
            // restDelMoneyTv.setText((int)restaurant.getmRestaurantDeliveryPrice() + " تومان ");
            restImg.setImageResource(restaurant.getmRestaurantImageAddress());

            restOfferTv.setText(restaurant.getmRestaurantOff() + "%");


        }


    }

    public class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {
        private List<Restaurant> restaurants;
        private Context context;

        public TaskAdapter(List<Restaurant> restaurantList) {
            restaurants = restaurantList;
        }


        public void setCrimes(List<Restaurant> restaurantList) {
            restaurants = restaurantList;
        }


        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.itemes_in_top_foods_rv, parent, false);
            TaskHolder crimeHolder = new TaskHolder(view);
            context = view.getContext();
            return crimeHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {


            Restaurant restaurant = restaurants.get(position);

            holder.bind(restaurant);
        }

        @Override
        public int getItemCount() {
            if (restaurants.size() > 8)
                return 8;
            else
                return restaurants.size();
        }

    }

    public class TaskAdapter2 extends RecyclerView.Adapter<TaskHolder2> {
        private List<Restaurant> restaurants;
        private Context context;

        public TaskAdapter2(List<Restaurant> restaurantList) {
            restaurants = restaurantList;
        }


        public void setCrimes(List<Restaurant> restaurantList) {
            restaurants = restaurantList;
        }


        @NonNull
        @Override
        public TaskHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.items_in_offer_rv, parent, false);
            TaskHolder2 crimeHolder = new TaskHolder2(view);
            context = view.getContext();
            return crimeHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull TaskHolder2 holder, int position) {


            Restaurant restaurant = restaurants.get(position);

            holder.bind(restaurant);
        }

        @Override
        public int getItemCount() {
            if (restaurants.size() > 7)
                return 7;
            else
                return restaurants.size();
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
                        scrollView.scrollTo(0,0);
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        scrollView.scrollTo(0,0);
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
