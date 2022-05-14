package com.example.appsforgood.data;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JSONWeatherParser {

	APICaller caller;
	ArrayList<Integer> hourTime = new ArrayList<>();
	ArrayList<Double> hourTemp = new ArrayList<>();
	ArrayList<Double> hourFeels = new ArrayList<>();
	ArrayList<Integer> hourHum = new ArrayList<>();
	ArrayList<List<Weather__1>> hourWeather = new ArrayList<>();

	/**
	 * constructor for the JSONWeatherParser class
	 * @param call an APICaller object
	 */
	public JSONWeatherParser(APICaller call){

		caller = call;

		}

	/**
	 * big method that reformats the json from the api and puts it into various arraylists for easier parsing
	 * @throws IOException
	 */
	public void convertJSON() throws IOException {

			// JSON file to Java object

			ObjectMapper mapper = new ObjectMapper();

			SampleWeather weatherSample = mapper.readValue(
					caller.getData(),
					SampleWeather.class);
			//System.out.println(weatherSample);

			//System.out.println("LAT: " + weatherSample.getLat());
			//System.out.println("LON: " + weatherSample.getLon());
			//System.out.println("TIMEZONE: " + weatherSample.getTimezone());
			//System.out.println("TIMEZONE_OFFSET: " + weatherSample.getTimezoneOffset());

			// Get "current" object
			Current current = weatherSample.getCurrent();
			//System.out.println("DT: " + current.getDt());
			//System.out.println("SUNRISE: " + current.getSunrise());

			// Get list of "weather" objects, you know this is a list because of the [ ... ]
			ArrayList<Weather> weatherList = (ArrayList<Weather>) current.getWeather();
			/*for (Weather weather : weatherList) {
				System.out.println("ID: " + weather.getId());
				System.out.println("DESCRIPTION: " + weather.getDescription());
			}
			*/

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

	/**
	 * accessor method for all the hourly temperatures
	 * @return an ArrayList with each of the temperatures for the next 48 hours starting with next closest hour
	 */
	public ArrayList<Double> getHourTemp(){
		return hourTemp;
	}

	/**
	 * accessor method for all the hourly "feels-like" temperatures
	 * @return an ArrayList with each of the "feels-like" temperatures for the next 48 hours starting with next closest hour
	 */
	public ArrayList<Double> getHourFeels(){
		return hourFeels;
	}

	/**
	 * accessor method for all the hourly times
	 * @return an ArrayList with each of the times (unix) for the next 48 hours starting with next closest hour
	 */
	public ArrayList<Integer> getHourTime(){
		return hourTime;
	}

	/**
	 * accessor method for all the hourly humidity
	 * @return an ArrayList with each of the humidities for the next 48 hours starting with next closest hour
	 */
	public ArrayList<Integer> getHourHum(){
		return hourHum;
	}

	/**
	 * accessor method for all the hourly weather information arrays
	 * @return an ArrayList with each of the weather information array for the next 48 hours starting with next closest hour
	 */
	public 	ArrayList<List<Weather__1>> getHourWeather(){
		return hourWeather;
	}

	/**
	 * accessor method to obtain the current time in unix
	 * @return the current time in unix
	 * @throws IOException
	 */
	public int currentDT() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getDt();
	}

	/**
	 * accessor method to obtain the current temperature
	 * @return the current temperature
	 * @throws IOException
	 */
	public double currentTemp() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getTemp();
	}

	/**
	 * accessor method to obtain the current "feels-like" temperature
	 * @return the current "feels-like" temperature
	 * @throws IOException
	 */
	public double currentFeels() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getFeelsLike();
	}

	/**
	 * accessor method to obtain the current humidity
	 * @return the current humidity
	 * @throws IOException
	 */
	public int currentHum() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getHumidity();
	}

	/**
	 * gets the current wind speed
	 * @return double in miles per hour of the wind speed
	 * @throws IOException
	 */
	public double currentWindSp() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getWindSpeed();
	}


	/**
	 * gets the wind direction
	 * @return an int of the wind direction in degrees
	 * @throws IOException
	 */
	public int currentWindDeg() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getWindDeg();
	}

	/**
	 * accesor method to obtain the current weather information array
	 * @return the current weather information array
	 * @throws IOException
	 */
	public List<Weather> currentWeather() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getWeather();
	}

	/**
	 * retrieves the UV index value from the current weather.
	 * @return a double of the UV index value
	 * @throws IOException
	 */
	public double getUVI() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getUvi();
	}

	/**
	 * gets the current weather's description from the api
	 * @return a string description of the current weather
	 * @throws IOException
	 */
	public String getWeatherList() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getWeather().get(0).getDescription();
	}

	/*
	public Double getRain() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		Rain rainSample = mapper.readValue(
				caller.getData(),
				Rain.class);

		double rain1h = rainSample.get1h();

		if(Objects.equals(rain1h, null))
			return 0.0;
		else
			return rain1h;
	}
	*/

	/**
	 * Gets the current cloud coverage percentage
	 * @return the current cloud coverage percentage
	 * @throws IOException
	 */
	public Integer getClouds() throws IOException{
		ObjectMapper mapper = new ObjectMapper();

		SampleWeather weatherSample = mapper.readValue(
				caller.getData(),
				SampleWeather.class);

		Current current = weatherSample.getCurrent();
		return current.getClouds();
	}

	/**
	 * this method will determine if there is supposed to be rain within the hour.
	 * only looks at the hourly data for the hour it's called during. later might change to looking at the next five hours.
	 * @return a boolean representative of if or if not it is supposed to rain.
	 */
	public boolean rain(){
		String weatherStr = hourWeather.get(0).get(0).toString();

		if ((weatherStr.charAt(30)=='R' || weatherStr.charAt(31)=='R') && (weatherStr.charAt(33)=='n' || weatherStr.charAt(34)=='n'))
			return true;

		else
			return false;
	}

	/**
	 * this method determines if it is supposed to snow within the hour
	 * only looks at the hourly data for the hour it's called during. later might change to looking at the next five hours.
	 * @return a boolean representative of if or if not it is going to snow
	 */
	public boolean snow(){
		String weatherStr = hourWeather.get(0).get(0).toString();

		if (weatherStr.charAt(30)=='S' && weatherStr.charAt(33)=='w')
			return true;

		else
			return false;
	}
}

