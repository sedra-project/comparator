package com.study.hotelcomparator.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
public class HotelDTO {
    private String name;
    private String city;
    private BigDecimal minPrice;
    private List<PriceOfferDTO> offers;

    public HotelDTO(String name, String city, BigDecimal minPrice, List<PriceOfferDTO> offers) {
        this.name = name;
        this.city = city;
        this.minPrice = minPrice;
        this.offers = offers;
    }

    public HotelDTO() {
    }

}
