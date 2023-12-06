package com.dev.models;

import com.dev.services.KeyGenerator;

public class Order {
    private long orderId;
    private boolean orderStatus;
    private long cartId;
    private long driverId;
    private String trackingUrl;
//    private DateTime orderTime; -- Todo: should change mysql schema
    private long addressId;

    public Order(boolean orderStatus, long cartId, long driverId, String trackingUrl, long addressId) {
        this.orderStatus = orderStatus;
        this.cartId = cartId;
        this.driverId = driverId;
        this.trackingUrl = trackingUrl;
        this.addressId = addressId;
    }

    public Order(){
        this.orderId = KeyGenerator.generateKey();
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public String getTrackingUrl() {
        return trackingUrl;
    }

    public void setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderStatus=" + orderStatus +
                ", cartId=" + cartId +
                ", driverId=" + driverId +
                ", trackingUrl='" + trackingUrl + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
