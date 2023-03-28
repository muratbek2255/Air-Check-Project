package com.example.sensorservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    private final LocalityClient localityClient;

    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository, LocalityClient localityClient) {
        this.sensorRepository = sensorRepository;
        this.localityClient = localityClient;
    }

    @Override
    public String addSensor(SensorRequest sensorRequest) {

        Sensor sensor = new Sensor();

        sensor.setName(sensorRequest.getSensorName());

        sensorRepository.save(sensor);

        localityClient.addSensorNameToLocality(sensorRequest);

        return "Sensor Created";
    }

    @Override
    public String deleteSensor(int id) {

        sensorRepository.deleteById(id);

        return "Deleted sensor";
    }

    @Override
    public String addAirQualityIndexToLocality(SensorUpdateAirQualityIndexRequest airQualityIndexRequest, int id) {

        Sensor sensor = sensorRepository.getById(id);

        sensor.setAirQualityIndex(airQualityIndexRequest.getAirQualityIndex());

        sensorRepository.save(sensor);

        return "Add Air Quality Index";
    }
}
