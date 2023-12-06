package com.dev.models;

import com.dev.services.KeyGenerator;

public class UserAddress {
    private long addressId;
    private String streetAddress;
    private String city;
    private String state;
    private long pincode;
    private long userId;

    public UserAddress() {
    }

    public UserAddress(String streetAddress, String city, String state, long pincode, long userId) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.userId = userId;
        this.addressId = KeyGenerator.generateKey();
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}