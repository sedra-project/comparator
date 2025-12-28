package com.study.hotelcomparator.domain.model;

import java.math.BigDecimal;

public class PriceOffer {
    private Provider provider;
    private BigDecimal pricePerNight;
    private String currency;

    public PriceOffer(Provider provider, BigDecimal pricePerNight, String currency) {
        this.provider = provider;
        this.pricePerNight = pricePerNight;
        this.currency = currency;
    }

    public Provider getProvider() {
        return provider;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return String.format("%s : %s %s", provider, pricePerNight, currency);
    }
}
