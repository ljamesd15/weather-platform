package com.weather.platform.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class WeatherControllerTest {

    @Test
    public void getWeatherDataTest() {
        WeatherController underTest = new WeatherController();
        assertFalse(underTest.getWeatherData().isEmpty());
    }
}
