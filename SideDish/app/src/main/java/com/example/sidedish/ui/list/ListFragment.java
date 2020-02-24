package com.example.sidedish.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.sidedish.R;
import com.example.sidedish.models.Restaurant;
import com.example.sidedish.ui.details.DetailsActivity;
import com.example.sidedish.ui.restaurant_update.UpdateRestaurantActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ListFragment extends Fragment {

    private ListViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModel =
                ViewModelProviders.of(this).get(ListViewModel.class);
        viewModel.resetView(getContext());
        View root = inflater.inflate(R.layout.fragment_list, container, false);

        final ArrayAdapter<Restaurant> restaurantAdapter = new ArrayAdapter<>(
            getContext(), R.layout.restaurant_item, R.id.lbl_name
        );
        viewModel.getRestaurants().observe(this, new Observer<List<Restaurant>>() {
            @Override
            public void onChanged(List<Restaurant> restaurants) {
                restaurantAdapter.clear();
                restaurantAdapter.addAll(restaurants);
            }
        });

        ListView restaurantList = root.findViewById(R.id.list_restaurants);
        restaurantList.setAdapter(restaurantAdapter);

        restaurantList.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Restaurant restaurant = restaurantAdapter.getItem(position);
                    startActivityForResult(
                        new Intent(
                            getContext(),
                            DetailsActivity.class
                        ).putExtra("ID", restaurant.id),
                        0
                    );
                }
            }
        );

        FloatingActionButton fab = root.findViewById(R.id.fab_list_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(
                    new Intent(
                        getContext(),
                        UpdateRestaurantActivity.class
                    ),
                    0
                );
            }
        });

        return root;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0)
            viewModel.resetView(getContext());
    }
}