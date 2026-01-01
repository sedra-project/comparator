package com.study.hotelcomparator.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
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

}
