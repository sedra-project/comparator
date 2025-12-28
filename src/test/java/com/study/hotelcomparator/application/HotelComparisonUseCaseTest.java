package com.study.hotelcomparator.application;

import com.study.hotelcomparator.application.service.ComparatorService;
import com.study.hotelcomparator.application.service.HotelComparisonUseCase;
import com.study.hotelcomparator.application.service.HotelSearchService;
import com.study.hotelcomparator.infrastructure.provider.ProviderClient;
import com.study.hotelcomparator.domain.model.Hotel;
import com.study.hotelcomparator.domain.model.PriceOffer;
import com.study.hotelcomparator.domain.model.Provider;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HotelComparisonUseCaseTest {

    @Mock
    HotelSearchService hotelSearchService;
    @Mock
    ComparatorService comparatorService;
    @Mock
    ProviderClient providerClient;
    @InjectMocks
    HotelComparisonUseCase useCase;

    @Test
    void should_aggregate_offers_from_all_providers() {
        Hotel h = new Hotel(1L,"Sunrise Palace","Paris");
        when(hotelSearchService.findHotelsByCity("Paris")).thenReturn(Arrays.asList(h));
        when(providerClient.fetchOffers(any(), any(), any()))
                .thenReturn(Arrays.asList(new PriceOffer(Provider.BOOKING,new BigDecimal("120"),"EUR")));

        useCase.compareHotels("Paris", LocalDate.now(), LocalDate.now().plusDays(1));

        verify(hotelSearchService).findHotelsByCity("Paris");
        verify(providerClient).fetchOffers(any(), any(), any());
    }
}
