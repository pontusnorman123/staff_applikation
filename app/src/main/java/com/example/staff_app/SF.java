package com.example.staff_app;

import java.util.ArrayList;

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

    public void incrementFoodAtPosition(int pos) {
        MenuItem f = foods.get(pos);
        f.incrementCounter();
        foods.set(pos, f);
        //foods.get(pos).incrementCounter();
        customAdapterFood.notifyItemChanged(pos);
        //customAdapterFood.notifyDataSetChanged();
    }

    public void incrementDrinkAtPosition(int pos) {
        MenuItem f = drinks.get(pos);
        f.incrementCounter();
        drinks.set(pos, f);
        //foods.get(pos).incrementCounter();
        customAdapterDrink.notifyItemChanged(pos);
        //customAdapterDrink.notifyDataSetChanged();
    }

    private SF() {
        //resetAll();
    }
}
