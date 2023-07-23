package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Sensor {

        private int id;

        private String name;


        private List<Measurements> measurements;

        @Override
        public String toString() {
            return "Sensor{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

    public Sensor(int id) {
        this.id = id;
    }

    public Sensor() {
    }
}

