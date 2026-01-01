package com.study.hotelcomparator.application.service;

import com.study.hotelcomparator.domain.model.Hotel;
import com.study.hotelcomparator.domain.model.HotelQuote;
import com.study.hotelcomparator.domain.model.PriceOffer;
import com.study.hotelcomparator.domain.service.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class HotelComparisonUseCase {

    private final ComparatorService comparatorService;
    private final List<ProviderClient> providerClients;

    @Autowired
    public HotelComparisonUseCase(ComparatorService comparatorService,
                                  List<ProviderClient> providerClients) {
        this.comparatorService = comparatorService;
        this.providerClients = providerClients;
    }

    public List<Hotel> compareHotels(String city,
                                     LocalDate checkIn,
                                     LocalDate checkOut) {

        List<Hotel> allHotels = new java.util.ArrayList<>();
        Map<String, Hotel> index = new HashMap<>();

        for (ProviderClient provider : providerClients) {
            List<HotelQuote> quotes = provider.fetchOffers(city, checkIn, checkOut);

            for (HotelQuote q : quotes) {
                String k = key(q.getCity(), q.getHotelName());

                Hotel hotel = index.computeIfAbsent(k, _k -> {
                    Hotel created = new Hotel(null, q.getHotelName(), q.getCity());
                    allHotels.add(created);
                    return created;
                });

                hotel.addOffer(new PriceOffer(q.getProvider(), q.getPricePerNight(), q.getCurrency()));
            }
        }

        return comparatorService.sortByMinimumPrice(allHotels);
    }

    private String key(String city, String hotelName) {
        return (isBlank(city) ? EMPTY : trim(toRootLowerCase(city))) + "|" +
                (isBlank(hotelName) ? EMPTY : trim(toRootLowerCase(hotelName)));
    }
}
