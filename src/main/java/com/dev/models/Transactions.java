package com.dev.models;

import com.dev.services.KeyGenerator;

public class Transactions {
    private long transactionId;
    private long orderId;
    private String transactionStatus;
    private String transactionType;
//    private String transactionTime; TODO: add this to schema

    public Transactions(){
        this.transactionId = KeyGenerator.generateKey();
    }

    public Transactions(long orderId, String transactionStatus, String transactionType) {
        this.orderId = orderId;
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
        this.transactionId = KeyGenerator.generateKey();
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactionId=" + transactionId +
                ", orderId=" + orderId +
                ", transactionStatus='" + transactionStatus + '\'' +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}
