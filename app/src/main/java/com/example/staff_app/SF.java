package com.example.staff_app;

import android.util.Log;

import java.util.ArrayList;

public class SF {
    // singleton class for orders
    public static SF s = new SF();

    public FoodCustomAdapter customAdapterFood;
    public DrinkCustomAdapter customAdapterDrink;
    public CartCustomAdapter customAdapterCart;
    private ArrayList<MenuItem> foods;
    private ArrayList<MenuItem> drinks;
    private ArrayList<MenuItem> cart;

    public ArrayList<MenuItem> getFoods() {return foods;}
    public ArrayList<MenuItem> getDrinks() {return drinks;}
    public ArrayList<MenuItem> getCart(){return cart;}

    public void resetAll() {
        foods = new ArrayList<>();
        drinks = new ArrayList<>();
        cart = new ArrayList<>();
    }

    public void addFood(MenuItem f) {
        foods.add(f);
    }

    public void addDrink(MenuItem d) {
        drinks.add(d);
    }

    public void addToCart(MenuItem c) {
        c.setCount(1);
       boolean lyckades = cart.add(c);
        Log.d("test", "clicked " + lyckades);
        customAdapterCart.notifyItemInserted(cart.size()-1);
        //customAdapterCart.notifyDataSetChanged();
    }

    public void removeFromCart(int pos) {
        // när det finns 0 kvar, kallar vi för att radera från SF
        cart.remove(pos);
        customAdapterCart.notifyItemRemoved(pos);
    }

    public void addFoods(ArrayList<MenuItem> f) {
        foods.addAll(f);
        customAdapterFood.notifyDataSetChanged();
    }

    private SF() {
        //resetAll();
    }


}
