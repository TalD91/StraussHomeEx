package com.strauss.RestAPIServer.models;


/**
 * The final object with all details merged together
 * into one object which the Spring framework translates to JSON response to the user
 */
public class UserResponse {
    private String id;
    private Boolean success;
    private Device deviceProperties;
    private WeatherDetails weatherDetails;
    private String recommendation;
    private String errorMessage;

    public UserResponse(String id, Device deviceProperties, Boolean success, WeatherDetails weatherDetails) {
        this.id = id;
        this.deviceProperties = deviceProperties;
        this.success = success;
        this.weatherDetails = weatherDetails;
        this.updateRecommendation();
    }
    public void updateRecommendation() {
        if (weatherDetails == null) {
            return;
        }
        if(weatherDetails.getSnow() > 0 || weatherDetails.getTemp() > 28) {
            recommendation = "Stay in the mazgan!! :)";
        }
        else {
            recommendation = "Working outside should be cool :)";
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Device getDeviceProperties() {
        return deviceProperties;
    }

    public void setDeviceProperties(Device deviceProperties) {
        this.deviceProperties = deviceProperties;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public WeatherDetails getWeatherDetails() {
        return weatherDetails;
    }

    public void setWeatherDetails(WeatherDetails weatherDetails) {
        this.weatherDetails = weatherDetails;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
