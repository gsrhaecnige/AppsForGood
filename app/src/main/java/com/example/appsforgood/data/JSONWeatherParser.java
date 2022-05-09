package com.example.appsforgood.data;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONWeatherParser {

	APICaller caller;
	ArrayList<Integer> hourTime = new ArrayList<>();
	ArrayList<Double> hourTemp = new ArrayList<>();
	ArrayList<Double> hourFeels = new ArrayList<>();
	ArrayList<Integer> hourHum = new ArrayList<>();
	ArrayList<List<Weather__1>> hourWeather = new ArrayList<>();

	public JSONWeatherParser(APICaller call){

		caller = call;

		}

	public void convertJSON() throws IOException {

			// JSON file to Java object

			ObjectMapper mapper = new ObjectMapper();

			SampleWeather weatherSample = mapper.readValue(
					caller.getData(),
					SampleWeather.class);
			//System.out.println(weatherSample);

			System.out.println("LAT: " + weatherSample.getLat());
			System.out.println("LON: " + weatherSample.getLon());
			System.out.println("TIMEZONE: " + weatherSample.getTimezone());
			System.out.println("TIMEZONE_OFFSET: " + weatherSample.getTimezoneOffset());

			// Get "current" object
			Current current = weatherSample.getCurrent();
			System.out.println("DT: " + current.getDt());
			System.out.println("SUNRISE: " + current.getSunrise());

			// Get list of "weather" objects, you know this is a list because of the [ ... ]
			ArrayList<Weather> weatherList = (ArrayList<Weather>) current.getWeather();
			for (Weather weather : weatherList) {
				System.out.println("ID: " + weather.getId());
				System.out.println("DESCRIPTION: " + weather.getDescription());
			}

			// Get list of "hourly" objects, you know this is a list because of the [ ... ]
			ArrayList<Hourly> hourlyList = (ArrayList<Hourly>) weatherSample.getHourly();
			for (Hourly hourly : hourlyList) {

				/*System.out.println("DT: " + hourly.getDt());
				System.out.println("TEMP: " + hourly.getTemp());
				System.out.println("HUMIDITY: " + hourly.getHumidity());*/

				hourTemp.add(hourly.getTemp());
				hourFeels.add(hourly.getFeelsLike());
				hourTime.add(hourly.getDt());
				hourHum.add(hourly.getHumidity());
				hourWeather.add(hourly.getWeather());
			}



			// KEEP GOING BASED ON THE DATA MODEL

	}

	public ArrayList<Double> getHourTemp(){
		return hourTemp;
	}

	public ArrayList<Double> getHourFeels(){
		return hourFeels;
	}

	public ArrayList<Integer> getHourTime(){
		return hourTime;
	}

	public ArrayList<Integer> getHourHum(){
		return hourHum;
	}

	public 	ArrayList<List<Weather__1>> getHourWeather(){
		return hourWeather;
	}

	public int currentDT() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getDt();
	}

	public double currentTemp() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getTemp();
	}

	public double currentFeels() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getFeelsLike();
	}

	public int currentHum() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getHumidity();
	}

	public List<Weather> currentWeather() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getWeather();
	}

}

