package com.openweathermap.kafka.connect.converter;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class StringSerializer implements Serializer<String> {

    private String encoding = "UTF-8";

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        String encodingProperty = (String) configs.get("encoding");

        if(encodingProperty != null) {
            this.encoding =  encodingProperty;
        }
    }

    @Override
    public byte[] serialize(String topic, String data) {
        if (data == null) {
            return new byte[0];
        }
        try {
            return data.getBytes(encoding);
        } catch (UnsupportedEncodingException e) {
            throw new SerializationException("Unsupported encoding: " + encoding);
        }
    }
}
