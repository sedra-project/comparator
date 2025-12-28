package com.study.hotelcomparator.infrastructure.provider;

import com.study.hotelcomparator.domain.model.PriceOffer;

import java.time.LocalDate;
import java.util.List;

public interface ProviderClient {
    List<PriceOffer> fetchOffers(String city, LocalDate checkIn, LocalDate checkOut);
}
