# real-time-weather-app
This project is a Spring Boot application designed to monitor and store real-time weather data for multiple cities. It fetches weather information from a public API and saves it to a MySQL database. The application features scheduled tasks to regularly update weather data and a RESTful API to retrieve stored information.
# Weather Monitoring System

## Overview
The Weather Monitoring System is a Spring Boot application that fetches weather data for multiple cities using the Weather API, stores it in a MySQL database, and exposes this data via a RESTful API.

## Codebase
You can find the complete codebase on [GitHub](https://github.com/DewanganPiyush/weather-monitoring-system).

## Design Choices
- **Architecture**: The application follows a layered architecture with clear separation between the controller, service, and data access layers.
- **Database**: MySQL is used as the database for storing weather data. A JPA repository is employed for data access.
- **Scheduling**: The application fetches weather data every 5 minutes using Spring's `@Scheduled` annotation.
- **DTOs**: Data Transfer Objects are used for parsing the API response to ensure a clean separation of concerns.

## Build Instructions
1. **Clone the Repository**
   ```bash
   git clone https://github.com/DewanganPiyush/weather-monitoring-system.git
   cd weather-monitoring-system
   
2. **Install Dependencies**
   Ensure you have Java (JDK 11 or above) and Maven installed. You can download them from:
   ```bash
   -Java JDK
   -Maven
  
4. **Build the Application**
   ```bash
   mvn clean install

5. **Set Up the Database**
   You can set up a MySQL database using Docker:
   ```bash
   docker run --name mysql-weather -e MYSQL_ROOT_PASSWORD=piyush -e MYSQL_DATABASE=weather_db -p 3306:3306 -d mysql:latest

5. **Configure Application Properties**
   Update src/main/resources/application.properties with your database credentials:
   ```bash
   spring.datasource.url=jdbc:mysql://localhost:3306/weather_db
   spring.datasource.username=root
   spring.datasource.password=piyush
   openweathermap.api.key=your_api_key

6. **Run the Application**
   ```bash
   mvn spring-boot:run

## Dependencies
-**Spring Boot**: For building the web application.
-**Spring Data JPA**: For database interactions.
-**MySQL Connector**: For connecting to the MySQL database.
-**RestTemplate**: For making HTTP requests to the Weather API.
-**Docker**: For containerizing the MySQL database.

## API Endpoints
-**GET /weather**: Fetches all weather data stored in the database.

## Notes
Ensure the database is running and accessible before starting the application.
Replace **your_api_key** in the **application.properties** file with your actual Weather API key.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
'''vbnet

### Additional Tips
- Update the GitHub link to point to your actual repository.
- Make sure to replace any placeholder values with your actual information.
- If you use additional tools or libraries, be sure to mention them in the dependencies section.




   

   




   
