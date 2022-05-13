package com.example.appsforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.appsforgood.data.Weather;

import java.io.IOException;
import java.util.ArrayList;

public class ForecastActivity extends MainActivity {

    private TextView tempText, feelsText, humText, uvText, windText, weatherText, descriptionText;
    private double textView1;
    private double textview2;
    int temp, feels, hum, uvi, windSpeed, windDeg, rainChance;
    private String weatherList;

    /**
     * Loads the Forecast view
     * @param savedInstanceState the saved state of the given view
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        tempText = findViewById(R.id.temperatureText);
        feelsText = findViewById(R.id.feelslikeText);
        humText = findViewById(R.id.humidityText);
        uvText = findViewById(R.id.UVindexText);
        windText = findViewById(R.id.windText);
        weatherText = findViewById(R.id.weatherText);
        descriptionText = findViewById(R.id.weatherdescText);

        //textView1 = findViewById(R.id.textView1);

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
                    temp = (int) jsonParser.currentTemp();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    feels = (int) jsonParser.currentFeels();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    hum = (int) jsonParser.currentHum();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    uvi = (int) jsonParser.currentUV();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    windSpeed = (int) jsonParser.currentWindSp();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    windDeg = (int) jsonParser.currentWindDeg();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try { weatherList = jsonParser.getWeatherList(); }
                catch (IOException e) { e.printStackTrace(); }

                //textView1 = getHour(0);
                //textView2 = getHour(1);

                /*
                try { rainChance = jsonParser.getRain(); }
                catch (IOException e) { e.printStackTrace(); }

                 */
            }

            //getAvgFeelsLike();

        }
        );
        thread.start();

        try {
            thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tempText.setText(Integer.toString(temp));
        feelsText.setText(Integer.toString(feels));
        humText.setText(Integer.toString(hum));
        uvText.setText(Integer.toString(uvi));
        weatherText.setText(weatherList);
        windText.setText(windSpeed + " mph");
    }

    protected void onStart() {
        super.onStart();
        //draw visual elements and do animations in here?
        //shoes = findViewById(R.id.shoesRecText);

    }

    private double getHour(int hour) {
        ArrayList<Double> hourTemps = jsonParser.getHourTemp();
        return hourTemps.get(hour);
    }

};
