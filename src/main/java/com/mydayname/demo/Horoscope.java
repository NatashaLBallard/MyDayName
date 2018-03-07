package com.mydayname.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Horoscope {

    private String type;

    private Value value;

    public Horoscope(){
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }


    @Override
    public String toString(){
        return "Horoscope{" +
                "type='" + type +'\'' +
                "value='" + value +'\'' +
                '}';
    }
}
