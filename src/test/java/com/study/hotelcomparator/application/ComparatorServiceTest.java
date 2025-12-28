package com.study.hotelcomparator.application;

import com.study.hotelcomparator.application.service.ComparatorService;
import com.study.hotelcomparator.domain.model.Hotel;
import com.study.hotelcomparator.domain.model.PriceOffer;
import com.study.hotelcomparator.domain.model.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComparatorServiceTest {
    @Autowired
    ComparatorService service;
    @Test
    void should_sort_hotels_by_min_price() {
        Hotel h1 = new Hotel(1L,"A","x");
        h1.addOffer(new PriceOffer(Provider.BOOKING,new BigDecimal("150"),"EUR"));
        Hotel h2 = new Hotel(2L,"B","x");
        h2.addOffer(new PriceOffer(Provider.BOOKING,new BigDecimal("100"),"EUR"));
        List<Hotel> sorted = service.sortByMinimumPrice(Arrays.asList(h1,h2));
        assertThat(sorted.get(0).getName()).isEqualTo("B");
    }
}
