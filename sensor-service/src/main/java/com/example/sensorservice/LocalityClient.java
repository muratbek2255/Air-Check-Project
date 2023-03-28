package com.example.sensorservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "locality-service", url = "http://localhost:8083")
public interface LocalityClient {

    @PostMapping("/localties/addSensor")
    public ResponseEntity<String> addSensorNameToLocality(@RequestBody SensorRequest sensorRequest);

}
