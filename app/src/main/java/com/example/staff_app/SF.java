package com.example.staff_app;

import androidx.recyclerview.widget.SortedList;

import java.util.ArrayList;

public class SF {
    // singleton class for orders
    public static SF s = new SF();

    public FoodCustomAdapter customAdapterFood;
    public FoodCustomAdapter customAdapterDrink;
    private ArrayList<Food> foods;
    private ArrayList<Food> drinks;

    public ArrayList<Food> getFoods() {return foods;}

    public void addFood(Food f) {
        foods.add(f);
    }

    public void addDrink(Food d) {
        foods.add(d);
    }

    public void addFoods(ArrayList<Food> f) {
        foods.addAll(f);
        customAdapterFood.notifyDataSetChanged();
    }

    public void incrementFoodAtPosition(int pos) {
        foods.get(pos).incrementCounter();
        customAdapterFood.notifyItemChanged(pos);
    }

    private SF() {
    }
}
