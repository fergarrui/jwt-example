package com.jwtexample.service;

import com.jwtexample.service.jsonmappers.weather.WeatherJson;

public class WeatherAPIService extends BaseAPIService<WeatherJson> {

	public WeatherAPIService(String url) {
		super(url);
	}
}
