package com.example.sidedish.models.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sidedish.models.RestaurantTag;

import java.util.List;

@Dao
public interface RestaurantTagsDao {
    @Query("SELECT * FROM RestaurantTag")
    List<RestaurantTag> getAll();
    @Query("SELECT * FROM RestaurantTag WHERE restaurantId=:restaurantId")
    List<RestaurantTag> getRestaurantTags(int restaurantId);
    @Update
    void update(RestaurantTag tag);
    @Insert
    void insert(RestaurantTag tag);
    @Delete
    void delete(RestaurantTag tag);
}
