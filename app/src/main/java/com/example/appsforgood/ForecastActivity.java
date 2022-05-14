package com.example.appsforgood;

import androidx.annotation.RequiresApi;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.example.appsforgood.data.Weather__1;

import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

public class ForecastActivity extends MainActivity {

    private TextView tempText, feelsText, humText, uvText, windText, weatherText, descriptionText;
    private TextView textView1, textView2, textView3, textView4, textView5, textView6,
            textView7, textView8, textView9, textView10, textView11, textView12;
    int temp, feels, hum, windSpeed, windDeg, rainChance;
    double uvi;
    private String weatherList;

    /**
     * Loads the Forecast view
     * @param savedInstanceState the saved state of the given view
     */
    @SuppressLint("NewApi")
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

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);

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
            thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tempText.setText(Integer.toString(temp) + "\u00B0");
        feelsText.setText(Integer.toString(feels) + "\u00B0");
        humText.setText(Integer.toString(hum) + "%");
        uvText.setText(Double.toString(uvi));
        weatherText.setText(weatherList);
        windText.setText(windSpeed + " mph");

        textView1.setText(militaryTime(getTime(), 1)  + ":00" +"\n" + Integer.toString((int) getHourly(0)) + "\u00B0");
        textView2.setText(militaryTime(getTime(), 2)  + ":00" +"\n" + Integer.toString((int) getHourly(1)) + "\u00B0");
        textView3.setText(militaryTime(getTime(), 3)  + ":00" +"\n" + Integer.toString((int) getHourly(2)) + "\u00B0");
        textView4.setText(militaryTime(getTime(), 4)  + ":00" +"\n" + Integer.toString((int) getHourly(3)) + "\u00B0");
        textView5.setText(militaryTime(getTime(), 5)  + ":00" +"\n" + Integer.toString((int) getHourly(4)) + "\u00B0");
        textView6.setText(militaryTime(getTime(), 6)  + ":00" +"\n" + Integer.toString((int) getHourly(5)) + "\u00B0");
        textView7.setText(militaryTime(getTime(), 7)  + ":00" +"\n" + Integer.toString((int) getHourly(6)) + "\u00B0");
        textView8.setText(militaryTime(getTime(), 8)  + ":00" +"\n" + Integer.toString((int) getHourly(7)) + "\u00B0");
        textView9.setText(militaryTime(getTime(), 9)  + ":00" +"\n" + Integer.toString((int)getHourly(8)) + "\u00B0");
        textView10.setText(militaryTime(getTime(), 10)  + ":00" +"\n" + Integer.toString((int) getHourly(9)) + "\u00B0");
        textView11.setText(militaryTime(getTime(), 11)  + ":00" +"\n" + Integer.toString((int) getHourly(10)) + "\u00B0");
        textView12.setText(militaryTime(getTime(), 12) + ":00" +"\n" + Integer.toString((int) getHourly(11)) + "\u00B0");

    }

    protected void onStart() {
        super.onStart();
        //draw visual elements and do animations in here?
        //shoes = findViewById(R.id.shoesRecText);

    }

    private double getHourly(int hour) {
        ArrayList<Double> hourTemps = jsonParser.getHourTemp();
        return hourTemps.get(hour);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private int getTime() {
        LocalDateTime date = LocalDateTime.now();
        return date.getHour();
    }

    private List<Weather__1> getDesc(int hour) {
        ArrayList<List<Weather__1>> descriptions = jsonParser.getHourWeather();
        return descriptions.get(hour);
    }

    /**
     * this helper method is for making sure the times in the upcoming forecast grid stay in the 24 hr bounds
     * @param time an integer of the time
     * @param n the number cell
     * @return an int of time + n in mod 24 if time + n != 12 or 24
     */
    private int militaryTime(int time, int n){
       int newTime = time + n;

       if (newTime == 12 || newTime == 24)
           return newTime;

       else
           return newTime %24;
    }

};
