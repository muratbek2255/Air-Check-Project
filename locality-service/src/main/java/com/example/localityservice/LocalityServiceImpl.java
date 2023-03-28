package com.example.localityservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalityServiceImpl implements LocalityService {

    private final LocalityRepository localityRepository;

    @Autowired
    public LocalityServiceImpl(LocalityRepository localityRepository) {
        this.localityRepository = localityRepository;
    }

    @Override
    public String addSensorsNameToLocality(SensorRequest sensorRequest) {

        Locality locality = new Locality();

        locality.setSensorsName(sensorRequest.getSensorName());

        localityRepository.save(locality);

        return "Add Sensors Name to Locality";
    }


    @Override
    public String addLocality(LocalityRequest localityRequest) {
        return null;
    }

    @Override
    public String deleteLocality(int id) {
        return null;
    }
}
