package com.example.sidedish.ui.restaurant_update;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.example.sidedish.SideDishDatabase;
import com.example.sidedish.models.Restaurant;
import com.example.sidedish.ui.list.ListViewModel;

public class UpdateRestaurantViewModel extends ViewModel {
    private Restaurant toUpdate;

    public boolean isNewRestaurant() {
        return this.toUpdate == null;
    }

    public Restaurant getRestaurant() {
        if (isNewRestaurant())
            return new Restaurant();
        return toUpdate;
    }
    public void setToUpdate(Restaurant restaurant) {
        toUpdate = restaurant;
    }
    public void onSubmit(SideDishDatabase database, Restaurant restaurant) {
        if (isNewRestaurant())
            database.restaurantDao().insert(restaurant);
        else
            database.restaurantDao().update(restaurant);
    }
}
