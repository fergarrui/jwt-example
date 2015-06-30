package com.jwtexample.service.jsonmappers.tube;

public class TubeLinePrediction {

	private String id;
	private String vehicleId;
	private String stationName;
	private String lineId;
	private String lineName;
	private String platformName;
	private String direction;
	private String destinationName;
	private Integer timeToStation;
	private String expectedArrival;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public Integer getTimeToStation() {
		return timeToStation;
	}
	public void setTimeToStation(Integer timeToStation) {
		this.timeToStation = timeToStation;
	}
	public String getExpectedArrival() {
		return expectedArrival;
	}
	public void setExpectedArrival(String expectedArrival) {
		this.expectedArrival = expectedArrival;
	}
	
}
