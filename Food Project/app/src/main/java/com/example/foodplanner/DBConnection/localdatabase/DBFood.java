package com.example.foodplanner.DBConnection.localdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.foodplanner.DBConnection.DBModel.FavoriteMeal;
import com.example.foodplanner.DBConnection.DBModel.PlanMeal;

@Database(entities = {FavoriteMeal.class, PlanMeal.class}, version = 1)
public abstract class DBFood extends RoomDatabase {
    private static DBFood instance = null;
    public abstract MealDAO mealDAO();

    public static synchronized DBFood getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(context.getApplicationContext(), DBFood.class, "mealDB").build();
        return instance;
    }



}