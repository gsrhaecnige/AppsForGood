package com.example.appsforgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    TextView currentLocationText, dateText;
    View weatherButton;
    double lat, lon;
    private FusedLocationProviderClient fusedLocationProviderClient;


    /**
     * Loads the Main view, gets date, gets location, displays forecast information,
     * displays basic clothing recommendations
     * @param savedInstanceState the saved state of the given view
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        dateText = findViewById(R.id.dateText);
        dateText.setText(getDate());

        weatherButton = findViewById(R.id.weatherButton);
        currentLocationText = findViewById(R.id.currentLocationText);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            getLocation();
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    44);
        }
        /*weatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            44);
                }
            }
        });*/
    }

    /**
     * Gets the current user location (latitude, longitude)
     */
    @SuppressLint("MissingPermission")
    private void getLocation() {
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                    try {
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),
                                location.getLongitude(), 1);
                        lat = addresses.get(0).getLatitude();
                        lon = addresses.get(0).getLongitude();

                        /*currentLocationText.setText((Html.fromHtml("<font color='#6200EE'><b>Longitude: </b><br></font>"
                                + lat
                                + "<br><font color='#6200EE'><b>Latitude: </b><br></font>"
                                + long)));
                         */
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //displayForecast();
        //displayClothing();

    }

    /**
     * Transitions to Forecast view
     * @param view the current View
     */
    public void performForecast(View view) {
        Intent intent = new Intent(this, ForecastActivity.class);
        startActivity(intent);
    }

    /**
     * Transitions to Clothing view
     * @param view the current View
     */
    public void performClothing(View view) {
        Intent intent = new Intent(this, ClothingActivity.class);
        startActivity(intent);
    }

    /**
     * Transitions to Main view
     * @param view the current View
     */
    public void performMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Gets the date in the format "Weekday, Month Day, Time Timezone"
     * @return date the formatted date as String
     */
    public String getDate() {
        DateFormat df = new SimpleDateFormat("EEE, MMM d, HH:mm z");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }



}