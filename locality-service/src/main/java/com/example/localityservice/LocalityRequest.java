package com.example.localityservice;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class LocalityRequest {

    String name;

    String longitude;

    String latitude;

}
