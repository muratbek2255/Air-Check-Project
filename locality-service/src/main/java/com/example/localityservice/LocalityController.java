package com.example.localityservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/localties")
public class LocalityController {

    private final LocalityServiceImpl localityService;

    @Autowired
    public LocalityController(LocalityServiceImpl localityService) {
        this.localityService = localityService;
    }

    @PostMapping("/addSensor")
    public ResponseEntity<String> addSensorNameToLocality(@RequestBody SensorRequest sensorRequest) {

        return ResponseEntity.status(201).body(localityService.addSensorsNameToLocality(sensorRequest));
    }
}
