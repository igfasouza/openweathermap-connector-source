package com.openweathermap.kafka.connect.converter;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class StringDeserializer implements Deserializer<String> {

    private String encoding = "UTF-8";

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        String encodingProperty = (String) configs.get("encoding");

        if(encodingProperty != null) {
            this.encoding =  encodingProperty;
        }
    }

    @Override
    public String deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }
        try {
            return new String(data, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new SerializationException("Unsupported encoding: " + encoding);
        }
    }
}
