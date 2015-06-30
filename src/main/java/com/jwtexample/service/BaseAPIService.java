package com.jwtexample.service;

import java.util.Map;
import org.springframework.web.client.RestTemplate;

public abstract class BaseAPIService<T> {

	protected String url;
	
	public BaseAPIService() {}
	
	public BaseAPIService(String url) {
		this.url = url;
	}

	public T readFromUrl( Map<String,String> params, Class<T> c ) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, c, params);
	}
	
	
}
