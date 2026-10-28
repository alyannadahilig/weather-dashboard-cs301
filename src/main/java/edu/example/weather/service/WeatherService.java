
package edu.example.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.weather.model.WeatherData;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;

public class WeatherService {

    public WeatherData loadWeather(String city) throws IOException {

        if (StringUtils.isBlank(city)) {
            throw new IllegalArgumentException("Please select a city.");
        }

        String fileName = "/sample-data/" + city.toLowerCase() + ".json";

        InputStream input = getClass().getResourceAsStream(fileName);

        if (input == null) {
            throw new IOException("Weather file not found: " + fileName);
        }

        ObjectMapper mapper = new ObjectMapper();

        try (input) {
            return mapper.readValue(input, WeatherData.class);
        }
    }
}

