package com.jwtexample.service.jsonmappers.weather;

import java.util.List;

public class WeatherJson {

	private WeatherCoord coord;
	private List<Weather> weather;
	
	public WeatherCoord getCoord() {
		return coord;
	}
	public void setCoord(WeatherCoord coord) {
		this.coord = coord;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	
}
