package com.example.sidedish.models.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sidedish.models.RestaurantItem;

import java.util.List;

@Dao
public interface RestaurantItemsDao {
    @Query("SELECT * FROM RestaurantItem")
    List<RestaurantItem> getAll();
    @Query("SELECT * FROM RestaurantItem where restaurantId=:restaurantId ")
    List<RestaurantItem> getByRestaurant(int restaurantId);
    @Insert
    void insert(RestaurantItem item);
    @Update
    void update(RestaurantItem item);
    @Delete
    void delete(RestaurantItem item);
}
