package com.example.localityservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface LocalityRepository extends JpaRepository<Locality, Integer> {

    @Query(value = "SELECT * FROM localties WHERE localties.id = ?1", nativeQuery = true)
    Locality getById(@Param("id") int id);
}
