package com.study.hotelcomparator.infrastructure.provider.dto;

import java.math.BigDecimal;

public class ProviderHotelPriceRow {
    private String name;
    private String city;
    private BigDecimal price;
    private String currency;

    public ProviderHotelPriceRow() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
