package com.strauss.RestAPIServer.models;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Device model for all stores devices
 */


@Document(collection = "devices")
public class Device {

    @Id
    private String id;

    private long lastHeartbeat;
    private double deviceLongitude;
    private double deviceLatitude;
    private short deviceHeight;
    private boolean enabled;
    private boolean connected;

    public Device(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getLastHeartbeat() {
        return lastHeartbeat;
    }

    public void setLastHeartbeat(long lastHeartbeat) {
        this.lastHeartbeat = lastHeartbeat;
    }

    public double getDeviceLongitude() {
        return deviceLongitude;
    }

    public void setDeviceLongitude(double deviceLongitude) {
        this.deviceLongitude = deviceLongitude;
    }

    public double getDeviceLatitude() {
        return deviceLatitude;
    }

    public void setDeviceLatitude(double deviceLatitude) {
        this.deviceLatitude = deviceLatitude;
    }

    public short getDeviceHeight() {
        return deviceHeight;
    }

    public void setDeviceHeight(short deviceHeight) {
        this.deviceHeight = deviceHeight;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public void updateHeartbeat() {
        this.lastHeartbeat = System.currentTimeMillis();
    }
}
