# Weather Platform

## Tech stack
Database: MongoDB
Backend service: Java + Spring

## Local development
To start the service
1. ```$ mvn clean package```
2. ```$ docker compose build```
   1. First time only
3. [Optional] Startup Database ```$ docker compose --profile db up```
   1. If you already have a MongoDB container running you can just bring up the essential services with ```$ docker compose up``` 
   2. You can set up mongo manually using [these docs](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-community-with-docker/)
      1. ```$ docker run -p 27017:27017 --restart unless-stopped --name mongodb -d mongodb/mongodb-community-server:latest```
4. [Docker] Run the service and gateway ```$ docker compose --profile gateway --profile service up```

### Initial mongo setup
```mongosh
use admin
db.createUser( { user: "WeatherPlatform", pwd: passwordPrompt(), roles: ["readWrite"] }, { w: "majority" , wtimeout: 5000 } )
db.createUser( { user: "WeatherReporting", pwd: passwordPrompt(), roles: [ { "role": "readWrite", "db": "weather" }, { role: "readAnyDatabase", db: "admin" } ] }, { w: "majority" , wtimeout: 5000 } )
```

### API Gateway - Kong
The API Gateway is started up with the docker profile ```gateway```.
You can generate a new secret with
```
$ export WEATHER_JWT_SECRET=$(openssl rand -hex 32 | base64 -w 0)
```

### Reporting/BI Connection
```cmd
$ cd "C:\Program Files\MongoDB\Connector for BI\2.14\bin"
$ mongosqld.exe /p 27017 /sampleNamespaces weather.weather /schemaName weather /schemaSource weather /schemaMode auto /sampleSize 0 --auth --mongo-username %MONGO_WEATHER_REPORTING% --mongo-password %MONGO_WEATHER_REPORTING_PASSWORD%
```

## Making a change
1. Make changes necessary and add unit tests
2. Run the new unit tests to ensure they pass
   1. Ex. ```mvn test -Dtest=WeatherServiceTest#saveWeatherDataTest```
3. Run all unit tests to ensure nothing broke ```mvn clean test```
4. Start service (see above) and manually smoke test changes
5. Add changes with a meaningful commit message
6. Push changes to a feature branch and submit a pull request to main branch