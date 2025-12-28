package com.study.hotelcomparator.infrastructure.provider;

import com.study.hotelcomparator.domain.model.PriceOffer;
import com.study.hotelcomparator.domain.model.Provider;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ExpediaProviderClient implements ProviderClient {
    @Override
    public List<PriceOffer> fetchOffers(String city, LocalDate checkIn, LocalDate checkOut) {
        return Arrays.asList(
                new PriceOffer(Provider.EXPEDIA, new BigDecimal("140"), "EUR"),
                new PriceOffer(Provider.EXPEDIA, new BigDecimal("110"), "EUR")
        );
    }
}
