package com.example.appsforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class ForecastActivity extends MainActivity {

    /**
     * Loads the Forecast view
     * @param savedInstanceState the saved state of the given view
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
    }

    protected void onStart() {
        super.onStart();
        //draw visual elements and do animations in here?
        //shoes = findViewById(R.id.shoesRecText);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try { //this is the .convertJSON method in try/catch
                    jsonParser.convertJSON();
                } catch (
                        IOException e) {
                    e.printStackTrace();
                }


                try {
                    int TempC = (int) jsonParser.currentTemp();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    int FeelsLikeC = (int) jsonParser.currentFeels();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    int HumC = (int) jsonParser.currentHum();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    int UviC = (int) jsonParser.currentUV();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    int UviC = (int) jsonParser.currentUV();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    int WindSpC = (int) jsonParser.currentWindSp();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    int WindSpC = (int) jsonParser.currentWindDeg();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //getAvgFeelsLike();

        }
        );
        thread.start();

        try {
            thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

};
