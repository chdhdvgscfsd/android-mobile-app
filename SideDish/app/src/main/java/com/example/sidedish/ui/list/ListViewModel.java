package com.example.sidedish.ui.list;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sidedish.SideDishDatabase;
import com.example.sidedish.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {
    private MutableLiveData<List<String>> tags;
    private MutableLiveData<List<Restaurant>> restaurants;

    public LiveData<List<String>> getTags() { return tags; }
    public LiveData<List<Restaurant>> getRestaurants() { return restaurants; }

    public ListViewModel() {
        tags = new MutableLiveData<>();
        restaurants = new MutableLiveData<>();
        restaurants.setValue(new ArrayList<Restaurant>());
        addTags();
    }

    public void resetView(Context context) {
        restaurants.setValue(
            SideDishDatabase.instance(context)
                .restaurantDao().getAll()
        );
    }

    public void searchByName(Context context, String name) {
        restaurants.setValue(
            SideDishDatabase.instance(context)
                .restaurantDao().searchByName(name)
        );
    }

    public void searchByTag(Context context, String tag) {
        restaurants.setValue(
            SideDishDatabase.instance(context)
                .restaurantDao().searchByTag(tag)
        );
    }

    private void addTags() {
        ArrayList <String> list = new ArrayList<>();
        tags.setValue(list);
        list.add("Organic");
        list.add("Vegan");
        list.add("Vegetarian");
        list.add("Thai");
        list.add("Chinese");
        list.add("Filipino");
        list.add("Canadian");
        list.add("Ethiopian");
        list.add("American");
        list.add("Russian");
        list.add("Indian");
        list.add("Korean");
        list.add("Chilean");
        list.add("Japanese");
        list.add("Greek");
        list.add("Italian");
        list.add("Portuguese");
        list.add("Turkish");
        list.add("Moroccan");
        list.add("Caribbean");
        list.add("Persian");
        list.add("Mexican");
        list.add("Vietnamese");
        list.add("Malaysian");
        list.add("French");
    }
}