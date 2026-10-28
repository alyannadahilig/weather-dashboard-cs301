
package edu.example.weather.ui;

import edu.example.weather.model.WeatherData;
import edu.example.weather.service.WeatherService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class WeatherDashboardView extends BorderPane {

    public WeatherDashboardView() {
        setPadding(new Insets(20));

        // Dashboard title
        Label title = new Label("Weather Dashboard");
        title.setStyle("-fx-font-size: 28;");

        // City dropdown
        ComboBox<String> cities = new ComboBox<>();
        cities.getItems().addAll("Seattle", "Redmond", "Bellevue");
        cities.setValue("Seattle");

        // Weather information
        Label temperature = new Label();
        Label condition = new Label();
        Label humidity = new Label();

        VBox center = new VBox(10, temperature, condition, humidity);
        center.setAlignment(Pos.CENTER);

        setTop(new VBox(10, title, cities));
        setCenter(center);

        // Load weather data
        WeatherService service = new WeatherService();

        cities.setOnAction(event -> {
            try {
                WeatherData weather = service.loadWeather(cities.getValue());

                temperature.setText(weather.temperature + "°F");
                condition.setText(weather.condition);
                humidity.setText("Humidity: " + weather.humidity + "%");

            } catch (Exception e) {
                temperature.setText("Could not load weather data");
                condition.setText("");
                humidity.setText("");
            }
        });

        // Display Seattle's weather when the app opens
        try {
            WeatherData weather = service.loadWeather("Seattle");

            temperature.setText(weather.temperature + "°F");
            condition.setText(weather.condition);
            humidity.setText("Humidity: " + weather.humidity + "%");

        } catch (Exception e) {
            temperature.setText("Could not load weather data");
        }
    }
}
