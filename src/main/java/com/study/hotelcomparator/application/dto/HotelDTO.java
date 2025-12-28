package com.study.hotelcomparator.application.dto;

import java.math.BigDecimal;
import java.util.List;

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

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public List<PriceOfferDTO> getOffers() {
        return offers;
    }

    public void setOffers(List<PriceOfferDTO> offers) {
        this.offers = offers;
    }
}
