package com.example.sensorservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {

    @Query(value = "SELECT * FROM sensors WHERE sensors.id = ?1", nativeQuery = true)
    Sensor getById(@Param("id") int id);

}
