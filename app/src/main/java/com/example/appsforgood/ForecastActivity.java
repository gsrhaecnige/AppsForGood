package com.example.appsforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

    /**
     * Transitions to Clothing view
     * @param view the current View
     */
    public void performClothing(View view) {
        super.performClothing(view);
    }

    /**
     * Transitions to Main view
     * @param view the current View
     */
    public void performMain(View view) {
        super.performMain(view);
    }
}