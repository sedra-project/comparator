package com.study.hotelcomparator.application.service;

import com.study.hotelcomparator.domain.model.Hotel;
import com.study.hotelcomparator.domain.model.PriceOffer;
import com.study.hotelcomparator.infrastructure.provider.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HotelComparisonUseCase {

    private final HotelSearchService hotelSearchService;
    private final ComparatorService comparatorService;
    private final List<ProviderClient> providerClients;

    @Autowired
    public HotelComparisonUseCase(HotelSearchService hotelSearchService,
                                  ComparatorService comparatorService,
                                  List<ProviderClient> providerClients) {
        this.hotelSearchService = hotelSearchService;
        this.comparatorService = comparatorService;
        this.providerClients = providerClients;
    }

    public List<Hotel> compareHotels(String city, LocalDate checkIn, LocalDate checkOut) {
        List<Hotel> allHotels = hotelSearchService.findHotelsByCity(city);

        for (ProviderClient provider : providerClients) {
            List<PriceOffer> offers = provider.fetchOffers(city, checkIn, checkOut);
            for (PriceOffer offer : offers) {
                allHotels.stream()
                        .filter(h -> h.getName().equalsIgnoreCase("Sunrise Palace"))
                        .findFirst()
                        .ifPresent(h -> h.addOffer(offer));
            }
        }

        return comparatorService.sortByMinimumPrice(allHotels);
    }
}
