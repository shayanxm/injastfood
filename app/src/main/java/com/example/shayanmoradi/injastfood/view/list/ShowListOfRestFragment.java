package com.example.shayanmoradi.injastfood.view.list;


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
import android.widget.TextView;
import android.widget.Toast;

import com.example.shayanmoradi.injastfood.R;
import com.example.shayanmoradi.injastfood.model.Restaurant;
import com.example.shayanmoradi.injastfood.model.StaticDataGenerator;
import com.example.shayanmoradi.injastfood.view.restpage.RestPageActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.shayanmoradi.injastfood.view.list.ShowListOfRestActivity.kindCode;
import static com.example.shayanmoradi.injastfood.view.list.ShowListOfRestActivity.searchString;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowListOfRestFragment extends Fragment {

    RecyclerView restKindsRv;
    private static int incomingPageInt = -1;
    String searchS;
    int partiationINt;
    TextView customerAddTv;
    Restaurant.Partiation partiationionzed;
    ImageView backIv;
    ImageView mailIv;
    List<Restaurant> showRestList = new ArrayList<>();

    public static ShowListOfRestFragment newInstance() {
        incomingPageInt = 0;
        Bundle args = new Bundle();

        ShowListOfRestFragment fragment = new ShowListOfRestFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public static ShowListOfRestFragment newInstance(int partiationINt) {
        incomingPageInt = 1;
        int kindInInt = -1;
        Bundle args = new Bundle();
        args.putSerializable(kindCode, partiationINt);
        ShowListOfRestFragment fragment = new ShowListOfRestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static ShowListOfRestFragment newInstance(String search) {
        incomingPageInt = 2;
        Bundle args = new Bundle();
        args.putSerializable(searchString, search);

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
        View view = inflater.inflate(R.layout.fragment_show_list_of_rest, container, false);

        setUpViewByIds(view);

        customerAddTv.setText(StaticDataGenerator.customerAddress);

        clickListners();

        incomingIntProcess();

        setUpRv();

        return view;
    }

    private void setUpRv() {
        restKindsRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        TaskAdapter tasksAdapter = new TaskAdapter(showRestList);
        restKindsRv.setAdapter(tasksAdapter);
    }

    private void setUpViewByIds(View view) {
        restKindsRv = view.findViewById(R.id.show_list_rv);
        backIv = view.findViewById(R.id.imageView4);
        customerAddTv = view.findViewById(R.id.customer_add_tv);
        mailIv = view.findViewById(R.id.imageView6);
    }

    private void clickListners() {
        customerAddTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertEditTextKeyboardShown();
            }
        });


        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        mailIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "در حال حاضر پیامی وجود ندارد", Toast.LENGTH_LONG).show();
            }
        });
    }


    private void incomingIntProcess() {
        switch (incomingPageInt) {
            case 0:
                showRestList = StaticDataGenerator.getInstance(getActivity()).getmAllRestList();

                break;
            case 1:

                partiationINt = (Integer) getArguments().getSerializable(kindCode);
                intPostToPartion();
                // Log.v("test",partiationINt+"");
                List<Restaurant> tempRest = new ArrayList<>();
                tempRest = StaticDataGenerator.getInstance(getActivity()).getmAllRestList();
                int counter = 0;
                for (int i = 0; i < tempRest.size(); i++) {
                    if (tempRest.get(i).getmRestKind() == partiationionzed)
                        showRestList.add(counter, tempRest.get(i));
                }

                break;
            case 2:
                searchS = (String) getArguments().getSerializable(searchString);
                break;
            default:
                break;

        }

    }

    private void intPostToPartion() {
        switch (partiationINt) {
            case 0:

                partiationionzed = Restaurant.Partiation.REsturant;
                break;
            case 1:
                partiationionzed = Restaurant.Partiation.Candy;
                break;
            case 2:
                partiationionzed = Restaurant.Partiation.Caffe;
                break;
            case 3:
                partiationionzed = Restaurant.Partiation.Others;
                break;
            default:
                break;

        }
    }

    class TaskHolder extends RecyclerView.ViewHolder {

        private TextView restNameTv;
        private TextView restDesTv;
        private TextView restAddTv;
        private TextView restDelMoneyTv;
        private ImageView restImg;


        private Restaurant mRestaurant;
        Context context;

        public TaskHolder(@NonNull final View itemView) {
            super(itemView);

            restNameTv = itemView.findViewById(R.id.rest_name_item);
            restDesTv = itemView.findViewById(R.id.rest_des_item);
            restAddTv = itemView.findViewById(R.id.rest_add_item);
            restDelMoneyTv = itemView.findViewById(R.id.rest_del_item);
            restImg = itemView.findViewById(R.id.rest_image_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    itemView.getContext();

                    Intent intent = RestPageActivity.newIntent(getActivity(), mRestaurant.getmRestaurantId());
                    startActivity(intent);


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
            restDelMoneyTv.setText((int) restaurant.getmRestaurantDeliveryPrice() + " تومان ");
            restImg.setImageResource(restaurant.getmRestaurantSecondImageAddress());
        }


    }

    public class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {
        private List<Restaurant> restaurants;
        private Context context;

        public TaskAdapter(List<Restaurant> restaurantList) {
            restaurants = restaurantList;
        }


        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.items_rest_sort_rv, parent, false);
            TaskHolder taskHolder = new TaskHolder(view);
            context = view.getContext();
            return taskHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {


            Restaurant restaurant = restaurants.get(position);

            holder.bind(restaurant);
        }

        @Override
        public int getItemCount() {
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

                        StaticDataGenerator.customerAddress = editText.getText().toString();
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
