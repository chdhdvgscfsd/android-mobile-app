package com.example.sidedish.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Restaurant {
    @PrimaryKey(autoGenerate=true)
    public int id;
    public String name;
    public String desc;
    public String phoneNum;

    @Override
    public String toString() { return name; }
}
