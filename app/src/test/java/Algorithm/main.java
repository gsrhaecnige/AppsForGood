package Algorithm;


import java.io.IOException;

import java.util.Scanner;

import Algorithm.data.APICaller;
import Algorithm.data.JSONWeatherParser;

public class main {


    public static void main(String[] args) throws IOException {

        System.out.println("Hello World");

        Scanner scan = new Scanner(System.in);

        double latitude = 43;
        double longitude = -72;

        APICaller caller = new APICaller(latitude,longitude);

        JSONWeatherParser parser = new JSONWeatherParser(caller);

        parser.convertJSON();



    }
}

