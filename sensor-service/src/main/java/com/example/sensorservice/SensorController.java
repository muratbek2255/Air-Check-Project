package com.example.sensorservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sensor")
public class SensorController {

    private final SensorServiceImpl sensorService;

    @Autowired
    public SensorController(SensorServiceImpl sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping
    public ResponseEntity<String> addSensor(@RequestBody SensorRequest sensorRequest) {

        return ResponseEntity.status(201).body(sensorService.addSensor(sensorRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSensor(@PathVariable int id) {

        return ResponseEntity.status(202).body(sensorService.deleteSensor(id));
    }

    @PutMapping("/addAirQualityIndex/{id}")
    public ResponseEntity<String> addAirQualityIndex(@RequestBody SensorUpdateAirQualityIndexRequest airQualityIndexRequest,
                                                     @PathVariable int id) {

        return ResponseEntity.status(201).body(sensorService.addAirQualityIndexToLocality(airQualityIndexRequest, id));
    }
}
