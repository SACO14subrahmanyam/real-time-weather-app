package com.example.weathermonitoringsystem.dto;

public class WeatherResponse {
    private Location location;
    private Current current;

    // Getters and Setters

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public static class Location {
        private String name;
        private String region;
        private String country;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    public static class Current {
        private double temp_c;
        private double wind_kph;
        private int humidity;
        private Condition condition;
        private long last_updated_epoch;

        // Getters and Setters
        public double getTemp_c() {
            return temp_c;
        }

        public void setTemp_c(double temp_c) {
            this.temp_c = temp_c;
        }

        public double getWind_kph() {
            return wind_kph;
        }

        public void setWind_kph(double wind_kph) {
            this.wind_kph = wind_kph;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }

        public long getLast_updated_epoch() {
            return last_updated_epoch;
        }

        public void setLast_updated_epoch(long last_updated_epoch) {
            this.last_updated_epoch = last_updated_epoch;
        }
    }

    public static class Condition {
        private String text;

        // Getters and Setters
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
