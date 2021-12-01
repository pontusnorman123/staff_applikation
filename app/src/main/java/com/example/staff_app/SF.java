package com.example.staff_app;

import androidx.recyclerview.widget.SortedList;

import java.util.ArrayList;

public class SF {
    // singleton class for orders
    public static SF s = new SF();

    public FoodCustomAdapter customAdapterFood;
    //public FoodCustomAdapter customAdapterDrink;
    private ArrayList<Food> foods;
    //private ArrayList<Food> drinks;

    public ArrayList<Food> getFoods() {return foods;}
    //public ArrayList<Food> getDrinks() {return drinks;}

    public void addFood(Food f) {
        foods.add(f);
    }

    public void addDrink(Food d) {
        //drinks.add(d);
    }

    public void addFoods(ArrayList<Food> f) {
        foods.addAll(f);
        customAdapterFood.notifyDataSetChanged();
    }

    public void incrementFoodAtPosition(int pos) {
        Food f = foods.get(pos);
        f.incrementCounter();
        foods.set(pos, f);
        //foods.get(pos).incrementCounter();
        //customAdapterFood.notifyItemChanged(pos);
        customAdapterFood.notifyDataSetChanged();
    }

//    public void incrementDrinkAtPosition(int pos) {
//        Food f = drinks.get(pos);
//        f.incrementCounter();
//        drinks.set(pos, f);
//        //foods.get(pos).incrementCounter();
//        //customAdapterFood.notifyItemChanged(pos);
//        customAdapterDrink.notifyDataSetChanged();
//    }

    private SF() {
        foods = new ArrayList<>();
        //drinks = new ArrayList<>();
    }
}
