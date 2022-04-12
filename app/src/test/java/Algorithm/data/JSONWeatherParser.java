package Algorithm.data;

import com.fasterxml.jackson.databind.ObjectMapper;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JSONWeatherParser {

	APICaller caller;

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
				System.out.println("DT: " + hourly.getDt());
				System.out.println("TEMP: " + hourly.getTemp());
				System.out.println("HUMIDITY: " + hourly.getHumidity());
			}

			System.out.println(hourlyList.size());
			System.out.println(hourlyList.get(0).getDt());
			System.out.println(hourlyList.get(1).getDt());
			System.out.println(hourlyList.get(2).getDt());


			// KEEP GOING BASED ON THE DATA MODEL

	}

}

