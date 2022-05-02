package com.example.appsforgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

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
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {

    TextView currentLocationText, dateText;
    View weatherButton;
    double lat, lon;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private static final String TAG = "MainActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;

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

        if(isServicesOK()){
            init();
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

    private void init(){
        SearchView locationSearch = (SearchView) findViewById(R.id.locationSearch);
        locationSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        //displayForecast();
        //displayClothing();

    }

    /**
     * Gets the current latitude
     * @return lat the latitude
     */
    public double getLatInit() {
        return lat;
    }

    /**
     * Gets the current longitude
     * @return lon the longitude
     */
    public double getLonInit() {
        return lon;
    }

    /**
     * Transitions to Forecast activity
     * @param view the current View
     */
    public void performForecast(View view) {
        Intent intent = new Intent(this, ForecastActivity.class);
        startActivity(intent);
    }

    /**
     * Transitions to Clothing activity
     * @param view the current View
     */
    public void performClothing(View view) {
        Intent intent = new Intent(this, ClothingActivity.class);
        startActivity(intent);
    }

    /**
     * Transitions to Main activity
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