package com.jwtexample.controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwtexample.service.TubeLineTimetableAPIService;
import com.jwtexample.service.WeatherAPIService;
import com.jwtexample.service.jsonmappers.weather.WeatherJson;
import com.jwtexample.service.jsonmappers.tube.TubeLinePrediction;

@RestController
public class ConsumerController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private TubeLineTimetableAPIService tubeLineTimetableAPIService;
    @Autowired
    private WeatherAPIService weatherAPIService;

    @RequestMapping(value = "/tube/{lineName}", method = RequestMethod.GET)
    public String tubeLine(@PathVariable("lineName") String lineName) {
        String ret = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, String> params = new HashMap<>();
            params.put("lineName", lineName);
            TubeLinePrediction[] json = tubeLineTimetableAPIService.readFromUrl(params, TubeLinePrediction[].class);
            ret = mapper.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            logger.error("Error parsing data.");
            return buildResponse(Boolean.FALSE, "Error parsing data.");
        }
        return ret;
    }

    @RequestMapping(value = "/weather/{cityName}", method = RequestMethod.GET)
    public String weather(@PathVariable("cityName") String cityName) {
        String ret = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, String> params = new HashMap<>();
            params.put("cityName", cityName);
            WeatherJson json = weatherAPIService.readFromUrl(params, WeatherJson.class);
            ret = mapper.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            logger.error("Error parsing data.");
            return buildResponse(Boolean.FALSE, "Error parsing data.");
        }
        return ret;
    }
}
