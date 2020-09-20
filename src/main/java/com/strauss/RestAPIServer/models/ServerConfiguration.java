package com.strauss.RestAPIServer.models;

/**
 * Server Configuration models directly connected from the general configuration JSON
 */

public class ServerConfiguration {

    private String dataConnectorDBType;
    private String dataConnectorDeviceType;

    private String weatherUrl;
    private String weatherHeaderRapidHostName;
    private String weatherHeaderRapidHostKey;
    private String weatherHeaderRapidKeyName;
    private String weatherHeaderRapidKey;

    public String getDataConnectorDBType() {
        return dataConnectorDBType;
    }

    public void setDataConnectorDBType(String dataConnectorDBType) {
        this.dataConnectorDBType = dataConnectorDBType;
    }

    public String getDataConnectorDeviceType() {
        return dataConnectorDeviceType;
    }

    public void setDataConnectorDeviceType(String dataConnectorDeviceType) {
        this.dataConnectorDeviceType = dataConnectorDeviceType;
    }

    public String getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(String weatherUrl) {
        this.weatherUrl = weatherUrl;
    }

    public String getWeatherHeaderRapidHostName() {
        return weatherHeaderRapidHostName;
    }

    public void setWeatherHeaderRapidHostName(String weatherHeaderRapidHostName) {
        this.weatherHeaderRapidHostName = weatherHeaderRapidHostName;
    }

    public String getWeatherHeaderRapidHostKey() {
        return weatherHeaderRapidHostKey;
    }

    public void setWeatherHeaderRapidHostKey(String weatherHeaderRapidHostKey) {
        this.weatherHeaderRapidHostKey = weatherHeaderRapidHostKey;
    }

    public String getWeatherHeaderRapidKeyName() {
        return weatherHeaderRapidKeyName;
    }

    public void setWeatherHeaderRapidKeyName(String weatherHeaderRapidKeyName) {
        this.weatherHeaderRapidKeyName = weatherHeaderRapidKeyName;
    }

    public String getWeatherHeaderRapidKey() {
        return weatherHeaderRapidKey;
    }

    public void setWeatherHeaderRapidKey(String weatherHeaderRapidKey) {
        this.weatherHeaderRapidKey = weatherHeaderRapidKey;
    }
}
