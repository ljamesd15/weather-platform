# Weather Platform

## Tech stack
Database: MongoDB
Backend service: Java + Spring

## Local development
To start the service
1. ```$ mvn clean package```
2. ```$ docker compose build```
   1. First time only
3. ```$ docker compose --profile db```
   1. If you already have a MongoDB container running you can just bring up the essential services with ```$ docker compose up``` 

## Making a change
1. Make changes necessary and add unit tests
2. Run the new unit tests to ensure they pass
   1. Ex. ```mvn test -Dtest=WeatherServiceTest#saveWeatherDataTest```
3. Run all unit tests to ensure nothing broke ```mvn clean test```
4. Start service (see above) and manually smoke test changes
5. Add changes with a meaningful commit message
6. Push changes to a feature branch and submit a pull request to main branch