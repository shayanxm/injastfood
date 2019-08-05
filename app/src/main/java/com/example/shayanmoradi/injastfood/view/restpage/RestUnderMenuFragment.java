package com.example.shayanmoradi.injastfood.view.restpage;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shayanmoradi.injastfood.R;
import com.example.shayanmoradi.injastfood.model.Bag;
import com.example.shayanmoradi.injastfood.model.Category;
import com.example.shayanmoradi.injastfood.model.Food;
import com.example.shayanmoradi.injastfood.model.StaticDataGenerator;
import com.example.shayanmoradi.injastfood.view.shoppingbag.ShoppingBagActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.shayanmoradi.injastfood.view.restpage.RestMenuFragment.CategoryId;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestUnderMenuFragment extends androidx.fragment.app.Fragment {
    TextView textView;
    RecyclerView restFoodMenuRv;
    int categoryId;
    Category currentCategory;
    List<Food> categoryFoods;
    Bag currentBag;
    int currentRestId;
    private ConstraintLayout goToShoppingBagBtn;


    public static RestUnderMenuFragment newInstance(int catId) {

        Bundle args = new Bundle();
        args.putSerializable(CategoryId, catId);

        RestUnderMenuFragment fragment = new RestUnderMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public RestUnderMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoryId = (Integer) getArguments().getSerializable(CategoryId);
        currentCategory = StaticDataGenerator.getInstance(getContext()).searchCategoryById(categoryId);
        currentRestId = currentCategory.getmCategoryRestaurantId();
        categoryFoods = currentCategory.getmFoodsInCAtegory();
        currentBag = Bag.getInstance(getActivity());


    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
        visInvisTheBtn();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rest_under_menu, container, false);

        restFoodMenuRv = view.findViewById(R.id.rest_under_menu_cv);
        goToShoppingBagBtn = view.findViewById(R.id.go_to_shopping_bag_cons);

        restFoodMenuRv.setLayoutManager(new LinearLayoutManager(getActivity()));


//        TaskAdapter tasksAdapter = new TaskAdapter(categoryFoods);
//        restFoodMenuRv.setAdapter(tasksAdapter);
        updateUI();

        visInvisTheBtn();


        goToShoppingBagBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShoppingBagActivity.class);
                startActivity(intent);

            }
        });

        return view;

    }

    private void visInvisTheBtn() {
        if (Bag.getInstance(getContext()).getAllCount() < 1)
//        List<Food> foodList = Bag.getInstance(getContext()).getMfoodsInBag();
//        if ((foodList.size() <= 0))
        {
            goToShoppingBagBtn.setVisibility(View.GONE);

        } else {
            goToShoppingBagBtn.setVisibility(View.VISIBLE);
        }
    }

    public void updateUI() {
        visInvisTheBtn();
        TaskAdapter tasksAdapter = new TaskAdapter(categoryFoods);

        if (tasksAdapter == null) {
            tasksAdapter = new TaskAdapter(categoryFoods);
            restFoodMenuRv.setAdapter(tasksAdapter);
        } else {
            tasksAdapter.notifyDataSetChanged();
            tasksAdapter.notifyDataSetChanged();

        }
        restFoodMenuRv.setAdapter(tasksAdapter);
    }

    class TaskHolder extends RecyclerView.ViewHolder {

        private TextView foodNameTv;
        private TextView foodDesTv;
        private TextView foodBasicPriceTv;
        private TextView foodFinalPriceTv;
        private ImageView foodImgIv;

        private Button addToBagBtn;
        private Button removeFromBagBtn;
        private TextView bagCount;
        private Food mfood;
        Context context;


        public TaskHolder(@NonNull final View itemView) {
            super(itemView);

            foodNameTv = itemView.findViewById(R.id.item_food_name);
            foodDesTv = itemView.findViewById(R.id.item_food_des);
            foodBasicPriceTv = itemView.findViewById(R.id.item_food_base_price);
            foodFinalPriceTv = itemView.findViewById(R.id.item_food_final_price);
            addToBagBtn = itemView.findViewById(R.id.add_to_bag_btn);
            removeFromBagBtn = itemView.findViewById(R.id.delete_from_bag_btn);
            bagCount = itemView.findViewById(R.id.bag_count);
            foodImgIv = itemView.findViewById(R.id.item_food_image);
            addToBagBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    currentBag.addToBag(mfood);
                    Bag.setInstance(currentBag);
                    visInvisTheBtn();
                    updateUI();


                }
            });
            removeFromBagBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentBag.removeFromBag(mfood);
                    currentBag.setMbagRestaurantId(currentRestId);
                    Bag.setInstance(currentBag);
                    visInvisTheBtn();
                    updateUI();


                }
            });
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

        public void bind(Food food) {
            mfood = food;

            ////
            //      set view up here
            ////

            foodNameTv.setText(food.getMfoodName());
            foodDesTv.setText(food.getMfoodDes());
            foodBasicPriceTv.setText(food.getMfoodPrice() + "تومان");
            int finalPrice= (int) (food.getMfoodPrice() - food.getMfoodPrice() * food.getMfoodOff() / 100);
            foodFinalPriceTv.setText(finalPrice+ "تومان");
            //  int foodCount = getFoodCount(food);
            int foodCount = food.getmFoodInBagCount();

            bagCount.setText(foodCount + "");
            foodImgIv.setImageResource(food.getMfoodImageAddress());
        }

        private int getFoodCount(Food food) {
            int foodCount = 0;
            if (currentBag.getMfoodsInBag() != null) {
                for (int i = 0; i < currentBag.getMfoodsInBag().size(); i++) {
                    if (currentBag.getMfoodsInBag().get(i).getMfoodId() == food.getMfoodId())
                        foodCount++;

                }
                return foodCount;
            }
            return 0;
        }


    }

    public class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {
        private List<Food> foods;
        private Context context;

        public TaskAdapter(List<Food> foodList) {
            foods = foodList;
        }


        public void setCrimes(List<Food> foodList) {
            foods = foodList;
        }


        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.items_in_under_menu_rv, parent, false);
            TaskHolder crimeHolder = new TaskHolder(view);
            context = view.getContext();
            return crimeHolder;
        }


        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {


            Food food = foods.get(position);

            holder.bind(food);
        }

        @Override
        public int getItemCount() {
            return foods.size();
        }

    }
}
