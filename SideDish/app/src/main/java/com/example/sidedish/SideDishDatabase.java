package com.example.sidedish;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.sidedish.models.ItemRating;
import com.example.sidedish.models.Restaurant;
import com.example.sidedish.models.RestaurantItem;
import com.example.sidedish.models.RestaurantTag;
import com.example.sidedish.models.dao.ItemRatingDao;
import com.example.sidedish.models.dao.RestaurantDao;
import com.example.sidedish.models.dao.RestaurantItemsDao;
import com.example.sidedish.models.dao.RestaurantTagsDao;

@Database(
    entities = {
        ItemRating.class, Restaurant.class,
        RestaurantItem.class, RestaurantTag.class
    },
    version = 1
)
public abstract class SideDishDatabase extends RoomDatabase {
    private static SideDishDatabase database = null;
    public static SideDishDatabase instance(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(
                context,
                SideDishDatabase.class,
                "SideDishDb"
            ).allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                    }
                })
                .build();
        }
        return database;
    }

    public abstract ItemRatingDao itemRatingDao();
    public abstract RestaurantDao restaurantDao();
    public abstract RestaurantItemsDao restaurantItemDao();
    public abstract RestaurantTagsDao restaurantTagsDao();
}
