package com.example.shayanmoradi.injastfood.view.menu;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shayanmoradi.injastfood.R;
import com.example.shayanmoradi.injastfood.model.Food;
import com.example.shayanmoradi.injastfood.model.Restaurant;
import com.example.shayanmoradi.injastfood.model.StaticDataGenerator;
import com.example.shayanmoradi.injastfood.view.list.ShowListOfRestActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    private TextView goToAllBtn;
    private TextView goToREstBtn;
    private TextView goToCandyBtn;
    private TextView goToCaffeBtn;
    private TextView goTOOthersBtn;
    List<Restaurant>allRestList;
    Restaurant testRest;
    RecyclerView restKindsRv;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_menu, container, false);
        goToAllBtn= view.findViewById(R.id.go_to_all_rest_btn);

 goToREstBtn=view.findViewById(R.id.go_to_rest_tv);
 goToCandyBtn=view.findViewById(R.id.go_to_candy_tv);
 goToCaffeBtn=view.findViewById(R.id.go_to_caffe_tv);
  goTOOthersBtn=view.findViewById(R.id.go_to_others_tv);


      allRestList=  StaticDataGenerator.getInstance(getActivity()).getmAllRestList();
      testRest=allRestList.get(0);
      List<Food> foodList=testRest.getmRestaurantAllFoods();
        goToAllBtn.setText(foodList.get(0).getMfoodName()+"xx"+foodList.get(1).getMfoodName());



goToAllBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       Intent intent=ShowListOfRestActivity.newIntent(getActivity());
    //   Intent intent= ShowListOfRestActivity.newIntent(getActivity());
        startActivity(intent);

    }
});
        goToREstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=ShowListOfRestActivity.newIntent(getActivity(),Restaurant.Partiation.REsturant);
                //   Intent intent= ShowListOfRestActivity.newIntent(getActivity());
                startActivity(intent);

            }
        });
        goToCandyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=ShowListOfRestActivity.newIntent(getActivity(),Restaurant.Partiation.Candy);
                //   Intent intent= ShowListOfRestActivity.newIntent(getActivity());
                startActivity(intent);

            }
        });
        goToCaffeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=ShowListOfRestActivity.newIntent(getActivity(),Restaurant.Partiation.Caffe);
                //   Intent intent= ShowListOfRestActivity.newIntent(getActivity());
                startActivity(intent);

            }
        });
        goTOOthersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=ShowListOfRestActivity.newIntent(getActivity(),Restaurant.Partiation.Others);
                //   Intent intent= ShowListOfRestActivity.newIntent(getActivity());
                startActivity(intent);

            }
        });



   return view;

    } class TaskHolder extends RecyclerView.ViewHolder {

        private TextView KindNameTv;
        private ImageView kindImgIv;

        private Restaurant mRestaurant;
        Context context;

        public TaskHolder(@NonNull final View itemView) {
            super(itemView);

           //
            // KindNameTv = itemView.findViewById(R.id.kind_name_tv);
            kindImgIv = itemView.findViewById(R.id.kind_image_image_view);

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
