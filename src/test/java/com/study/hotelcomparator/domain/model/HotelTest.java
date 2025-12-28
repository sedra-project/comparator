package com.study.hotelcomparator.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HotelTest {
    @Test
    public void should_return_min_price(){
        Hotel h = new Hotel(1L, "Sunshine", "Paris");
        h.addOffer(new PriceOffer(Provider.BOOKING, new java.math.BigDecimal("100"), "EUR"));
        h.addOffer(new PriceOffer(Provider.EXPEDIA, new java.math.BigDecimal("200"), "EUR"));
        h.addOffer(new PriceOffer(Provider.AGODA, new java.math.BigDecimal("300"), "EUR"));
        assertThat(h.getMinPrice()).isEqualTo(new java.math.BigDecimal("100"));
    }
}
