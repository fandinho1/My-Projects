package com.demoqa.restapi.models;

public class City {
	
	private String City;
	private String Temperature;
	private String Humidity;
	private String WeatherDescription;
	private String WindSpeed;
	private String IndDirectionDegree;
	
	public City(String city, String temperature, String humidity, String weatherDescription, String windSpeed,
			String indDirectionDegree) {
		super();
		this.City = city;
		this.Temperature = temperature;
		this.Humidity = humidity;
		this.WeatherDescription = weatherDescription;
		this.WindSpeed = windSpeed;
		this.IndDirectionDegree = indDirectionDegree;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getTemperature() {
		return Temperature;
	}

	public void setTemperature(String temperature) {
		Temperature = temperature;
	}

	public String getHumidity() {
		return Humidity;
	}

	public void setHumidity(String humidity) {
		Humidity = humidity;
	}

	public String getWeatherDescription() {
		return WeatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		WeatherDescription = weatherDescription;
	}

	public String getWindSpeed() {
		return WindSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		WindSpeed = windSpeed;
	}

	public String getIndDirectionDegree() {
		return IndDirectionDegree;
	}

	public void setIndDirectionDegree(String indDirectionDegree) {
		IndDirectionDegree = indDirectionDegree;
	}
	
}
