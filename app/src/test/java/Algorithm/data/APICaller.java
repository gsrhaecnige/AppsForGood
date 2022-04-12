package Algorithm.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APICaller{

    private double lat;
    private double lon;

    // Create a new value object to hold the URL
    private URL url;

    public APICaller(double latitude, double longitude) throws MalformedURLException{
        lat = latitude;
        lon = longitude;
        url = new URL("https://api.openweathermap.org/data/2.5/onecall?lat="+lat+"&lon="+lon+"&exclude=minutely&units=imperial&appid=eb14331301c3974f2a420e33f3c2d3c8");

    }


    public String getData() throws IOException {
        // Open a connection on the URL and cast the response
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        //Make stream reader from connection
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());

        //Make bufferedreader from/for the inputstream
        BufferedReader in = new BufferedReader(reader);

        //Print the line read through bufferedreader
        //System.out.println(in.readLine());

        return in.readLine();
    }
}
