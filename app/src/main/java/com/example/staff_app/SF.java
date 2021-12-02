package com.example.staff_app;

import java.util.ArrayList;
import java.util.Collections;

public class SF {
    // singleton class for orders
    public static SF s = new SF();

    public FoodCustomAdapter customAdapterFood;
    public DrinkCustomAdapter customAdapterDrink;
    private ArrayList<MenuItem> foods;
    private ArrayList<MenuItem> drinks;

    public ArrayList<MenuItem> getFoods() {return foods;}
    public ArrayList<MenuItem> getDrinks() {return drinks;}

    public void resetAll() {
        foods = new ArrayList<>();
        drinks = new ArrayList<>();
    }

    public void addFood(MenuItem f) {
        foods.add(f);
    }

    public void addDrink(MenuItem d) {
        drinks.add(d);
    }

    public void addFoods(ArrayList<MenuItem> f) {
        foods.addAll(f);
        customAdapterFood.notifyDataSetChanged();
    }

    private SF() {
        //resetAll();
    }

    public void bringFoodToTopAtPosition(int pos) {
        //find first with 0
        Collections.swap(foods, pos, foods.size()-1);
        customAdapterFood.notifyDataSetChanged();
    }
}
