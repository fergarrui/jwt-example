package com.jwtexample.service.jsonmappers.tube;

import java.util.List;

public class TubeLineJson {

	private List<TubeLinePrediction> predictions;

	public List<TubeLinePrediction> getPredictions() {
		return predictions;
	}

	public void setPredictions(List<TubeLinePrediction> predictions) {
		this.predictions = predictions;
	}
	
}
