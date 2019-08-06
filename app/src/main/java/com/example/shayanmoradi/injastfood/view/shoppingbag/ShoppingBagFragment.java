package com.example.shayanmoradi.injastfood.view.shoppingbag;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shayanmoradi.injastfood.R;
import com.example.shayanmoradi.injastfood.model.Bag;
import com.example.shayanmoradi.injastfood.model.Category;
import com.example.shayanmoradi.injastfood.model.Food;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingBagFragment extends androidx.fragment.app.Fragment {
    RecyclerView restFoodMenuRv;
    int categoryId;
    Category currentCategory;
    List<Food> ShoppingBagFoods = new ArrayList<>();
    private TextView totalPriceTv;
    Bag currentBag;
    int currentRestId;
    private ConstraintLayout finilizeBagCons;
    private TextView restNameTv;
    private ImageView clearBagBtn;
    ImageView backIv;
    Bag bag;

    public static ShoppingBagFragment newInstance() {

        Bundle args = new Bundle();

        ShoppingBagFragment fragment = new ShoppingBagFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ShoppingBagFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentBag = Bag.getInstance(getContext());
        currentRestId = Bag.getInstance(getContext()).getMbagRestaurantId();
        ShoppingBagFoods = currentBag.getmFoodsInBagUnic();
        currentBag = Bag.getInstance(getActivity());
        Bag.getInstance(getContext()).removeZeroCount();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_shopping_bag, container, false);
        setUpViewWithIds(view);
        totalPriceTv.setText(Bag.getInstance(getContext()).totalPriaceCalculater() + "");
        clickListners();

        restFoodMenuRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();

        return view;
    }

    private void clickListners() {
        clearBagBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "سبد خرید خالی شد.", Toast.LENGTH_LONG).show();

                Bag.emptizeTheBag(getActivity());
                getActivity().finish();
            }
        });
        finilizeBagCons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "سفارش با موفقیت ثبت شد.", Toast.LENGTH_LONG).show();

                Bag.emptizeTheBag(getActivity());
                getActivity().finish();
            }
        });
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    private void setUpViewWithIds(View view) {
        totalPriceTv = view.findViewById(R.id.total_bag_price_tv);
        restNameTv = view.findViewById(R.id.rest_name_shopping);
        clearBagBtn = view.findViewById(R.id.clear_bag_iv);
        finilizeBagCons = view.findViewById(R.id.finialize_bag_cons);
        restFoodMenuRv = view.findViewById(R.id.shopping_bag_rv);
        backIv = view.findViewById(R.id.imageView4);
    }

    public void updateUI() {

        totalPriceTv.setText(Bag.getInstance(getContext()).totalPriaceCalculater() + "");
        TaskAdapter tasksAdapter = new TaskAdapter(ShoppingBagFoods);

        if (tasksAdapter == null) {
            tasksAdapter = new TaskAdapter(ShoppingBagFoods);
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
            addToBagBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    currentBag.addToBag(mfood);
                    Bag.setInstance(currentBag);
                    updateUI();


                }
            });
            removeFromBagBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentBag.removeFromBag(mfood);
                    currentBag.setMbagRestaurantId(currentRestId);
                    Bag.setInstance(currentBag);
                    updateUI();


                    //
                    if (mfood.getmFoodInBagCount() == 0 && currentBag.getMfoodsInBag().size() <= 1) {
                        Toast.makeText(getActivity(), "سبد خرید خالی شد", Toast.LENGTH_SHORT).show();
                        getActivity().finish();
                    }

                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    itemView.getContext();


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
            foodFinalPriceTv.setText(food.getMfoodPrice() - food.getMfoodPrice() * food.getMfoodOff() / 100 + "تومان");
//            int foodCount = getFoodCount(food);
            int foodCount = food.getmFoodInBagCount();
            bagCount.setText(foodCount + "");
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





        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.items_shopping_bag_rv, parent, false);
            TaskHolder taskHolder = new TaskHolder(view);
            context = view.getContext();
            return taskHolder;
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
