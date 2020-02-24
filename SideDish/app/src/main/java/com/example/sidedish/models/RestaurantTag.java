package com.example.sidedish.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Restaurant.class,
            childColumns = "restaurantId",
            parentColumns = "id")
    }
)
public class RestaurantTag {
    @PrimaryKey(autoGenerate=true)
    public int id;
    @ColumnInfo(index=true)
    public int restaurantId;
    @ColumnInfo(index=true)
    public String tag;
}
