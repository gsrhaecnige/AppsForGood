package com.example.appsforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //displayForecast();
        //displayClothing();
    }

    public void performForecast(View view) {
        Intent intent = new Intent(this, ForecastActivity.class);
        startActivity(intent);
    }

    public void performClothing(View view) {
        Intent intent = new Intent(this, ClothingActivity.class);
        startActivity(intent);
    }

    public void performMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}