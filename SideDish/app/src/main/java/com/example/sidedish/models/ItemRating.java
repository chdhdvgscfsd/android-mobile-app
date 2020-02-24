package com.example.sidedish.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = RestaurantItem.class,
            childColumns = "itemId",
            parentColumns = "id")
    }
)
public class ItemRating {
    @PrimaryKey(autoGenerate=true)
    public int id;
    @ColumnInfo(index=true)
    public int itemId;
    public int rating;
}
