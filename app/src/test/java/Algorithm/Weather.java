package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import java.io.IOException;

import javax.script.*;





public class Weather {
    private int dailyMin;
    private int dailyMax;
    private int dailyAvg;
    private String WFullSTRING;

    private URL url;
    private ArrayList hourly = new ArrayList<Integer>();

    public Weather() throws IOException {
    url = new URL("https://api.openweathermap.org/data/2.5/onecall?lat=42.2713&lon=-71.798889&exclude=minutely&units=imperial&appid=eb14331301c3974f2a420e33f3c2d3c8");

    // Open a connection on the URL and cast the response
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    //Make stream reader from connection
    InputStreamReader reader = new InputStreamReader(connection.getInputStream());

    //Make bufferedreader from/for the inputstream
    BufferedReader in = new BufferedReader(reader);

    //Print the line read through bufferedreader
        WFullSTRING=in.readLine();
    }


    //Unix to Military - NEEDS OFFSET
    public static double UnixToMilitary(int unix){
        int leftoverSeconds = unix%86400; //86400 = amount of seconds in a day

        int hours = leftoverSeconds/3600; //3600 = number of seconds in an hour

        leftoverSeconds %= 3600; //finds the seconds leftover after taking the hours out

        int minutes = leftoverSeconds / 60;

        return hours + (minutes/60);

    }





}
