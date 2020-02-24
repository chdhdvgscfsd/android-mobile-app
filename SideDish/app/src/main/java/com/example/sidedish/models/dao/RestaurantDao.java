package com.example.sidedish.models.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sidedish.models.Restaurant;

import java.util.List;

@Dao
public interface RestaurantDao {
    @Query("SELECT * FROM Restaurant")
    List<Restaurant> getAll();

    @Query("SELECT * FROM Restaurant WHERE id=:id")
    Restaurant getById (int id);

    @Query("SELECT * FROM Restaurant WHERE name LIKE  '%' || :name || '%'")
    List<Restaurant> searchByName(String name);

    @Query("SELECT r.* FROM Restaurant r, RestaurantTag t WHERE t.restaurantId = r.id AND t.tag = :tag")
    List<Restaurant> searchByTag(String tag);

    @Update
    void update (Restaurant restaurant);

    @Insert
    void insert (Restaurant restaurant);

    @Delete
    void delete (Restaurant restaurant);
}
