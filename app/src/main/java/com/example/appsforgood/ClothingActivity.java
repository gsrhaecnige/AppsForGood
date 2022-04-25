package com.example.appsforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class ClothingActivity extends MainActivity {

    /**
     * Loads the Clothing view
     * @param savedInstanceState the saved state of the given view
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);
    }

    /**
     * Transitions to Forecast view
     * @param view the current View
     */
    public void performForecast(View view) {
        super.performForecast(view);
    }

    /**
     * Transitions to Main view
     * @param view the current View
     */
    public void performMain(View view) {
        super.performMain(view);
    }
}