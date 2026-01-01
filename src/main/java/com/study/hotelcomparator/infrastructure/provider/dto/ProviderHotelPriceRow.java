package com.study.hotelcomparator.infrastructure.provider.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProviderHotelPriceRow {
    private String name;
    private String city;
    private BigDecimal price;
    private String currency;

    public ProviderHotelPriceRow() {
    }

}
