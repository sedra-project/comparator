package com.study.hotelcomparator.domain.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PriceOffer {
    private Provider provider;
    private BigDecimal pricePerNight;
    private String currency;

    public PriceOffer(Provider provider, BigDecimal pricePerNight, String currency) {
        this.provider = provider;
        this.pricePerNight = pricePerNight;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return String.format("%s : %s %s", provider, pricePerNight, currency);
    }
}
