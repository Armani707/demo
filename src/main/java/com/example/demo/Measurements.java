package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
@Getter
@Setter
@NoArgsConstructor
public class Measurements {
        private int id;

        private double value;

        private boolean raining;

        private Sensor sensor;

    @Override
    public String toString() {
        return "Measurements{" +
                "id=" + id +
                ", value=" + value +
                ", raining=" + raining +
                ", sensor=" + sensor +
                '}';
    }
}

