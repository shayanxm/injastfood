package com.example.shayanmoradi.injastfood.view.list;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shayanmoradi.injastfood.R;
import com.example.shayanmoradi.injastfood.model.Restaurant;
import com.example.shayanmoradi.injastfood.model.StaticDataGenerator;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.shayanmoradi.injastfood.view.list.ShowListOfRestActivity.kindCode;
import static com.example.shayanmoradi.injastfood.view.list.ShowListOfRestActivity.searchString;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowListOfRestFragment extends Fragment {
    Restaurant testRest;
    RecyclerView restKindsRv;
    private static int incomingPageInt = -1;
    String searchS;
    int partiationINt;
    Restaurant.Partiation partiationionzed;
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
//        switch (partiation) {
//            case REsturant:
//                kindInInt = 0;
//
//                args.putSerializable(kindCode, kindInInt);
//                break;
//            case Candy:
//                kindInInt = 1;
//                args.putSerializable(kindCode, kindInInt);
//                break;
//            case Caffe:
//                kindInInt = 2;
//                args.putSerializable(kindCode, kindInInt);
//
//                break;
//            case Others:
//                kindInInt = 3;
//                args.putSerializable(kindCode, kindInInt);
//
//                break;
//
//
//        }

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
        Log.v("test", (Integer) getArguments().getSerializable(kindCode) + "");
        restKindsRv = view.findViewById(R.id.show_list_rv);


        restKindsRv.setLayoutManager(new LinearLayoutManager(getActivity()));


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


        TaskAdapter tasksAdapter = new TaskAdapter(showRestList);
        restKindsRv.setAdapter(tasksAdapter);
        return view;

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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    //    mTask.setYesForEditNoForCreate(false);
                    itemView.getContext();


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
            restDelMoneyTv.setText(restaurant.getmRestaurantDeliveryPrice() + "");
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
            View view = inflater.inflate(R.layout.items_rest_sort_rv, parent, false);
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
            return restaurants.size();
        }

    }

}
