package com.example.sidedish.models.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sidedish.models.ItemRating;

import java.util.List;

@Dao
public interface ItemRatingDao {
    @Query("SELECT * FROM ItemRating")
    List<ItemRating> getAll();
    @Update
    void update(ItemRating rating);
    @Insert
    void insert(ItemRating rating);
    @Delete
    void delete(ItemRating id);
}
