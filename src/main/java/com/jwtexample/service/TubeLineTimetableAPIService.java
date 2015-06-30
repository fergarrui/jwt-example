package com.jwtexample.service;

import com.jwtexample.service.jsonmappers.tube.TubeLinePrediction;

public class TubeLineTimetableAPIService extends BaseAPIService<TubeLinePrediction[]>{

	public TubeLineTimetableAPIService(String url){
		super(url);
	}
}
