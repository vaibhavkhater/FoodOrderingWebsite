package com.dev.models;

import com.dev.services.KeyGenerator;

import java.sql.Time;

public class Restaurant {
    private long restaurantId;
    private String restaurantName;
    private Time startTime;
    private Time endTime;
    private long phoneNumber;
    private String streetAddress;
    private String city;
    private String state;
    private long pincode;
    private double rating;
    private long numberOfUsersRated;
    private String restaurantDescription;
    private boolean isVegeterian;

    public Restaurant(String restaurantName, Time startTime, Time endTime, long phoneNumber, String streetAddress, String city, String state, long pincode, double rating, long numberOfUsersRated, String restaurantDescription, boolean isVegeterian) {
        this.restaurantName = restaurantName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.rating = rating;
        this.numberOfUsersRated = numberOfUsersRated;
        this.restaurantDescription = restaurantDescription;
        this.restaurantId = KeyGenerator.generateKey();
        this.isVegeterian = isVegeterian;
    }

    public Restaurant() {
        this.restaurantId = KeyGenerator.generateKey();
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getNumberOfUsersRated() {
        return numberOfUsersRated;
    }

    public void setNumberOfUsersRated(long numberOfUsersRated) {
        this.numberOfUsersRated = numberOfUsersRated;
    }

    public String getRestaurantDescription() {
        return restaurantDescription;
    }

    public void setRestaurantDescription(String restaurantDescription) {
        this.restaurantDescription = restaurantDescription;
    }

    public boolean isVegeterian() {
        return isVegeterian;
    }

    public void setVegeterian(boolean vegeterian) {
        isVegeterian = vegeterian;
    }

    @Override
    public String toString() {
        return "restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", PhoneNumber=" + phoneNumber +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode=" + pincode +
                ", rating=" + rating +
                ", numberOfUsersRated=" + numberOfUsersRated +
                ", restaurantDescription='" + restaurantDescription + '\'' +
                ", isVegeterian=" + isVegeterian +
                '}';
    }
}
