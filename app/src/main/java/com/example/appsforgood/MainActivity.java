package com.example.appsforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        TextView dateText = (TextView)findViewById(R.id.dateText);
        dateText.setText(getDate());
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

    public String getDate() {
        DateFormat df = new SimpleDateFormat("EEE, MMM d, HH:mm z");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }
}