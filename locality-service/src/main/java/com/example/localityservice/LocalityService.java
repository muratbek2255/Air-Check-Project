package com.example.localityservice;


public interface LocalityService {


    public String addSensorsNameToLocality(SensorRequest sensorRequest);

    public String addLocality(LocalityRequest localityRequest);

    public String deleteLocality(int id);
}
