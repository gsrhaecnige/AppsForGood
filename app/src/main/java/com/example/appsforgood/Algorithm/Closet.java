package com.example.appsforgood.Algorithm;

import com.example.appsforgood.Algorithm.clothing.Accessories;
import com.example.appsforgood.Algorithm.clothing.Clothing;

import java.io.IOException;
import java.util.ArrayList;

public class Closet {
    //Storage for all clothing, accesories, and ratings
    private ArrayList<Clothing> closet;
    private ArrayList<Accessories> vanity;
    private ArrayList<Double> ratings;

    //Weather variable for rating
    private Weather weather;


    public Closet() throws IOException {
        weather = new Weather();
    };

    public Closet(Weather w){
        weather = w;
    };



    public double rateClothing(Clothing c){
        return 0;
    }
}
