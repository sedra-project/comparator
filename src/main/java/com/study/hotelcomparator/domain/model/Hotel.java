package com.study.hotelcomparator.domain.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private Long id;
    @Getter
    private String name;
    @Getter
    private String city;
    @Getter
    private final List<PriceOffer> offers = new ArrayList<>();

    public Hotel(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public void addOffer(PriceOffer offer) {
        offers.add(offer);
    }

    public java.math.BigDecimal getMinPrice() {
        return offers.stream()
                .map(PriceOffer::getPricePerNight)
                .min(java.math.BigDecimal::compareTo)
                .orElse(java.math.BigDecimal.ZERO);
    }

}
