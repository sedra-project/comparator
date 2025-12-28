package com.study.hotelcomparator.infrastructure.provider;

import com.study.hotelcomparator.domain.model.PriceOffer;
import com.study.hotelcomparator.domain.model.Provider;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class AgodaProviderClient implements ProviderClient {
    @Override
    public List<PriceOffer> fetchOffers(String city, LocalDate checkIn, LocalDate checkOut) {
        return Arrays.asList(
                new PriceOffer(Provider.AGODA, new BigDecimal("130"), "EUR"),
                new PriceOffer(Provider.AGODA, new BigDecimal("100"), "EUR"));
    }
}
