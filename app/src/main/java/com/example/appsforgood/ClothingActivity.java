package com.example.appsforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.appsforgood.Algorithm.clothing.*;
import com.example.appsforgood.data.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;


public class ClothingActivity extends MainActivity {

    Top t = new Top();
    Bottom b = new Bottom();
    Shoes s = new Shoes();
    Accessories a = new Accessories();

    double feelsLike = 0;

    //JSONWeatherParser jsonParser = new JSONWeatherParser(api);

    /**
     * Loads the Clothing view
     * @param savedInstanceState the saved state of the given view
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);
    }

    public void performForecast(View view) {
        super.performForecast(view);
    }

    public void performMain(View view) {
        super.performMain(view);
    }

    /*
    private void getAvgFeelsLike(){
        ArrayList<Double> feelsLikeList = jsonParser.getHourFeels();

        for (Double temp: feelsLikeList){
            feelsLike += temp;
        }

        feelsLike /= feelsLikeList.size();
    }

     */

    @Override
    protected void onStart(){
        super.onStart();
        //draw visual elements and do animations in here?
/*
        try { //this is the .convertJSON method in try/catch
            jsonParser.convertJSON();
        } catch (IOException e) {
            e.printStackTrace();
        }

        getAvgFeelsLike();
*/
        onResume();
    }

    @Override
    protected void onResume(){
        super.onResume();

        //this is where the app interacts with the user
    }

    @Override
    protected void onPause(){
        super.onPause();

    }

    @Override
    protected void onStop(){
        super.onStop();
        //called when this view is no longer being viewed
        //stop refreshing UI, running animations and other visual things in here
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void generateTop(View view){

    }
}