package com.aoher.sevice.impl;

import com.aoher.sevice.WeatherService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("raining")
public class RainingDayService implements WeatherService {

    @Override
    public String forecast() {
        return "Today is raining day!";
    }
}
