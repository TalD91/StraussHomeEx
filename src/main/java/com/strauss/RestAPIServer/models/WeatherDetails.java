package com.strauss.RestAPIServer.models;

import net.minidev.json.JSONObject;

/**
 * Object to store all weather details from the weather API
 */
public class WeatherDetails {
    private String timezone;
    private String countryCode;
    private String cityName;
    private double temp;
    private int snow;

    public WeatherDetails() {}

    public WeatherDetails(String timezone, String countryCode, String cityName, JSONObject weather, double temp, int snow) {
        this.timezone = timezone;
        this.countryCode = countryCode;
        this.cityName = cityName;
        this.temp = temp;
        this.snow = snow;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getSnow() {
        return snow;
    }

    public void setSnow(int snow) {
        this.snow = snow;
    }
}
