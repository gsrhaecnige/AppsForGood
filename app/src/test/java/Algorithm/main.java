package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class main {


    public static void main(String[] args) throws IOException {

        System.out.println("Hello World");

        String timetest = null;

        // Create a new value object to hold the URL
        URL url = new URL("https://api.openweathermap.org/data/2.5/onecall?lat=42.2713&lon=-71.798889&exclude=minutely&units=imperial&appid=eb14331301c3974f2a420e33f3c2d3c8");

        // Open a connection on the URL and cast the response
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        //Make stream reader from connection
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());

        //Make bufferedreader from/for the inputstream
        BufferedReader in = new BufferedReader(reader);

        //Print the line read through bufferedreader
        System.out.println(in.readLine());
        System.out.println(timetest = in.readLine().substring(in.readLine().indexOf("1648"),in.readLine().indexOf("1648")+6));



    }
}

