package com.dev.models;

import com.dev.services.KeyGenerator;

import java.util.Date;

public class Promocode {
    private long promocodeId;
    private String promoName;
    private Date startDate;
    private Date endDate;
    private double discount;
    private double minimumOrderValue;
    private String promoDescription;

    public Promocode() {
        this.promocodeId = KeyGenerator.generateKey();
    }

    public Promocode(String promoName, Date startDate, Date endDate, double discount, double minimumOrderValue, String promoDescription) {
        this.promoName = promoName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discount = discount;
        this.minimumOrderValue = minimumOrderValue;
        this.promoDescription = promoDescription;
        this.promocodeId = KeyGenerator.generateKey();
    }

    public long getPromocodeId() {
        return promocodeId;
    }

    public void setPromocodeId(long promocodeId) {
        this.promocodeId = promocodeId;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getMinimumOrderValue() {
        return minimumOrderValue;
    }

    public void setMinimumOrderValue(double minimumOrderValue) {
        this.minimumOrderValue = minimumOrderValue;
    }

    public String getPromoDescription() {
        return promoDescription;
    }

    public void setPromoDescription(String promoDescription) {
        this.promoDescription = promoDescription;
    }

    @Override
    public String toString() {
        return "Promocode{" +
                "promocodeId=" + promocodeId +
                ", promoName='" + promoName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", discount=" + discount +
                ", minimumOrderValue=" + minimumOrderValue +
                ", promoDescription='" + promoDescription + '\'' +
                '}';
    }
}
