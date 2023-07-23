package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Slf4j
@Component
public class RestService {


    private final RestTemplate restTemplate;

    @Autowired
    public RestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public void addMeasurements() {
        Sensor sensor = new Sensor(21);
        MeasurementsDto measurementsDto = new MeasurementsDto(67.5, true, sensor);
        Map <String, Object> map = new HashMap<>();  //map по типу JSON
        map.put("value", measurementsDto.getValue());
        map.put("raining", measurementsDto.isRaining());
        map.put("sensor", measurementsDto.getSensor());
        log.info("INFORMATION");
        HttpEntity<Map <String, Object>> httpEntity = new HttpEntity<>(map);  //перевозчик в http
        restTemplate.postForEntity("http://localhost:8080/api/measurements/add", httpEntity, MeasurementsDto.class);
    }

    public void addSensor () {
        SensorDto sensorDto = new SensorDto("MK21");
        Map <String, Object> sensorMap = new HashMap<>();
        sensorMap.put("name", sensorDto.getName());

        log.info("INFORMATION");
        HttpEntity<Map <String, Object>> httpEntity = new HttpEntity<>(sensorMap);
        restTemplate.postForEntity("http://localhost:8080/api/sensors/registration", httpEntity, SensorDto.class);

    }

    public List<?> getMeasurements () {
        return restTemplate.getForObject("http://localhost:8080/api/measurements", List.class);
    }

    public int getRainyDaysCount () {
        return restTemplate.getForObject("http://localhost:8080/api/measurements/rainyDaysCount", int.class);
    }

}


