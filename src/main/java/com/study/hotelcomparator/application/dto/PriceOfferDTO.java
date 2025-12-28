package com.study.hotelcomparator.application.dto;

import java.math.BigDecimal;

public class PriceOfferDTO {
    private String provider;
    private BigDecimal pricePerNight;
    private String currency;

    public PriceOfferDTO(String provider, BigDecimal pricePerNight, String currency) {
        this.provider = provider;
        this.pricePerNight = pricePerNight;
        this.currency = currency;
    }

    public PriceOfferDTO() {
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
