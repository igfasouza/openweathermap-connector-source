## Source Kafka connector

This is a example of Kafka Connector to the openweathermap API.

[openweathermap](https://openweathermap.org/)

### Deploy

    mvn package


### run Docker

```
docker run -it --rm --name weather-connect-demo -p 8083:8083 -e GROUP_ID=1 \
    -e BOOTSTRAP_SERVERS="bootstrap_URL" \
    -e CONFIG_STORAGE_TOPIC=”ID-config” \
    -e OFFSET_STORAGE_TOPIC=”ID-offset” \
    -e STATUS_STORAGE_TOPIC=”ID-status” \
    -v openweathermap-connector/target/openweathermap-connector-0.0.1-SNAPSHOT-jar-with-dependencies.jar/:/kafka/connect/openweathermap-connector \
    debezium/connect:latest
```
    
### Configure

```
{
   "name": "weathermap-connector",
  "config": {
      "connector.class":"com.openweathermap.kafka.connect.WeatherAPIConnector",
      "Value.converter":"com.openweathermap.kafka.connect.converter.StringConverter",
      "value.converter.encoding":"UTF-8",
      "tasks.max": "1",
      "open.weather.api.key":"12312312312312313123123123123",
      "cities": "Ireland, Brazil",
      "kafka.topic":"weather",
      "name":"weathermap-connector",
      "transform":"ReplaceField,IntegrityCheck",
      "transform.ReplaceField.type":"com.openweathermap.kafka.connect.transform.ReplaceField$Value",
      "transform.ReplaceField.blacklist":"main",
      "transform.IntegrityCheck.type":"com.openweathermap.kafka.connect.transform.IntegrityCheck$Value",
       "transform.IntegrityCheck.field":"integrity"
  }
}
```

### License

Free - Open
