# Weather Dashboard

This project is a simple weather dashboard that displays weather information for Seattle, Redmond, and Bellevue. It uses JavaFX for the interface and reads weather data from JSON files.

## Features

- Choose between three cities using a dropdown menu.
- View the temperature, weather condition, and humidity for each city.
- See the weather information update when a different city is selected.

## Libraries Used

- **JavaFX:** Used to create the dashboard and display the weather information.
- **Jackson:** Used to read the weather data from the JSON files.
- **Apache Commons Lang:** Used to check if the city name is empty or only contains spaces before loading its weather information.

I chose Apache Commons Lang as my additional third-party library because it has built-in methods that make working with strings easier. For this project, I used `StringUtils.isBlank()` to check the city name before reading its JSON file. This helps prevent the program from trying to load weather data when no valid city is provided.

## How to Run

To run the application:

```bash
make run
```

To build the project:

```bash
make build
```

To create the fat JAR file:

```bash
make jar
```

To run the fat JAR:

```bash
java -jar build/libs/weather-dashboard-all.jar
```

To remove generated build files:

```bash
make clean
```

## Build Automation

This project uses Gradle and a Makefile to make building and running the application easier. It also includes a GitHub Actions workflow that automatically builds the project and uploads the fat JAR when a pull request is opened against the `main` branch.