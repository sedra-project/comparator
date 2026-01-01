package com.study.hotelcomparator.domain.service;

import com.study.hotelcomparator.domain.model.HotelQuote;

import java.time.LocalDate;
import java.util.List;

public interface ProviderClient {
    List<HotelQuote> fetchOffers(String city, LocalDate checkIn, LocalDate checkOut);
}
