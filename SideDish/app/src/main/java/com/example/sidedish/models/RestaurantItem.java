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
public class RestaurantItem {
    @PrimaryKey(autoGenerate=true)
    public int id;
    @ColumnInfo(index=true)
    public int restaurantId;
    public String name;
    public String desc;

}
