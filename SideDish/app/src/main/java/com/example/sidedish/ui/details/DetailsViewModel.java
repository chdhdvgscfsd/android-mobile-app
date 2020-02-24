package com.example.sidedish.ui.details;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sidedish.SideDishDatabase;
import com.example.sidedish.models.Restaurant;
import com.example.sidedish.models.RestaurantItem;
import com.example.sidedish.models.RestaurantTag;
import com.example.sidedish.ui.list.ListViewModel;

import java.util.List;

public class DetailsViewModel extends ViewModel {
    private MutableLiveData<Restaurant> restaurant;
    private MutableLiveData<List<RestaurantTag>> tags;
    private MutableLiveData<List<RestaurantItem>> items;

    public LiveData<Restaurant> getRestaurant() { return restaurant; }
    public LiveData<List<RestaurantTag>> getTags() { return tags; }
    public LiveData<List<RestaurantItem>> getItems() { return items; }


    public DetailsViewModel (){
        restaurant = new MutableLiveData<>();
        tags = new MutableLiveData<>();
        items = new MutableLiveData<>();
    }

    public void onDelete(Context context, ListViewModel listModel) {
        Restaurant item = restaurant.getValue();
        if (item == null) return;
        SideDishDatabase.instance(context)
            .restaurantDao().delete(item);
        listModel.resetView(context);
    }

    public void setRestaurant(Context context, int id){
        SideDishDatabase instance = SideDishDatabase.instance(context);
        Restaurant item = instance.restaurantDao().getById(id);
        if (item == null) return;
        restaurant.setValue(item);
        tags.setValue(
            instance
                .restaurantTagsDao()
                .getRestaurantTags(item.id)
        );
        items.setValue(
            instance
                .restaurantItemDao()
                .getByRestaurant(item.id)
        );
    }
}
