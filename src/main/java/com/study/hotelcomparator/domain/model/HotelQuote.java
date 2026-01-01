package com.study.hotelcomparator.domain.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class HotelQuote {

    private final String hotelName;
    private final String city;
    private final Provider provider;
    private final BigDecimal pricePerNight;
    private final String currency;

    public HotelQuote(String hotelName, String city, Provider provider, BigDecimal pricePerNight, String currency) {
        this.hotelName = hotelName;
        this.city = city;
        this.provider = provider;
        this.pricePerNight = pricePerNight;
        this.currency = currency;
    }

}
