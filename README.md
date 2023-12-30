# Weather Station Dashboard

## Purpose of the App

The Weather Station Dashboard is a Spring Boot application designed to provide users with both Martian and Earth local weather data. The application fetches and displays daily weather updates from the Mars Curiosity Rover and a local weather service, presenting a unique dashboard that compares the terrestrial and Martian climates.

## Technology Used

- **Java**: The primary programming language used.
- **Spring Boot**: Framework used for creating the application.
- **Spring Web**: For making RESTful web services.
- **RestTemplate/WebClient**: To consume external weather APIs.
- **Jackson/Gson**: For JSON parsing.
- **In-Memory Database**: (H2/other) for storing any persistent data if needed.
- **Maven/Gradle**: For dependency management and building the project.
- **JUnit/Mockito**: For unit and integration testing.
- **Thymeleaf**: Optional for server-side rendering of HTML if a UI is included.

## Logic of the App

### Overview

The application is designed with a clear separation of concerns in mind, divided into client and service layers handling different aspects of the application.

### Client Layer

- **Purpose**: The client layer is responsible for interacting with external APIs. It contains the logic to make HTTP requests, handle responses, and parse them into Java objects.
- **Components**:
    - `MarsWeatherClient`: Fetches weather data from the Mars Weather API.
    - `LocalWeatherClient`: Fetches local weather data based on specified geographic coordinates.

### Service Layer

- **Purpose**: The service layer contains the business logic of the application. It processes data retrieved from clients and prepares it for presentation or further analysis.
- **Components**:
    - `WeatherService`: An interface defining the contract for weather data services.
    - `MarsWeatherService` and `LocalWeatherService`: Implementations of `WeatherService` for handling Mars and local weather data, respectively.

### Data Models

- **DailyWeatherData**: A base class representing common attributes of daily weather data.
- **MarsWeatherData**: Extends `DailyWeatherData` to include specific attributes from the Mars weather API.
- **LocalWeatherData**: Extends `DailyWeatherData` to include specific attributes from the local weather API.

### Flow of the Application

1. **Data Fetching**: At scheduled intervals, the application uses the client classes to fetch the latest weather data from the respective APIs.
2. **Data Processing**: The service layer processes this data, perhaps caching it, transforming it, or combining it with other data as needed.
3. **Data Presentation**: Finally, the processed data is made available to the presentation layer, ready to be displayed on the dashboard.

## License

The App is open source

## Contact

Best is to contact me via Github or find me on Twitter: @singularitypl

