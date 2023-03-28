package com.example.sensorservice;


public interface SensorService {

    public String addSensor(SensorRequest sensorRequest);

    public String deleteSensor(int id);

    public String addAirQualityIndexToLocality(SensorUpdateAirQualityIndexRequest airQualityIndexRequest, int id);
}
