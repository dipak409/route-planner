package com.dipak.routeplanner;

public class Route
{
    private String source;
    private String destination;
    private String distance;
    private String time;
    private String price;

    public Route(String source, String destination, String distance, String time, String price) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.time = time;
        this.price = price;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
