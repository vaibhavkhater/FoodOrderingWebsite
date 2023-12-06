package com.dev.models;

import com.dev.services.KeyGenerator;

public class Driver {
    private long driverId;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private long NumberOfUsersRated;
    private double rating;

    public Driver() {
        this.driverId = KeyGenerator.generateKey();
    }

    public Driver(String firstName, String lastName, long phoneNumber, long numberOfUsersRated, double rating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        NumberOfUsersRated = numberOfUsersRated;
        this.rating = rating;
        this.driverId = KeyGenerator.generateKey();
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getNumberOfUsersRated() {
        return NumberOfUsersRated;
    }

    public void setNumberOfUsersRated(long numberOfUsersRated) {
        NumberOfUsersRated = numberOfUsersRated;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "driver{" +
                "driverId=" + driverId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", NumberOfUsersRated=" + NumberOfUsersRated +
                ", rating=" + rating +
                '}';
    }
}
