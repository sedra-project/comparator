package com.study.hotelcomparator.infrastructure.provider.mockclient;

import com.study.hotelcomparator.domain.model.HotelQuote;
import com.study.hotelcomparator.domain.model.Provider;
import com.study.hotelcomparator.infrastructure.provider.mock.BookingProviderClientMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@ActiveProfiles("mock")
public class BookingProviderClientMockTest {
    @Autowired
    private BookingProviderClientMock bookingProviderClientMock;

    @Test
    void should_return_quotes_for_city() {
        List<HotelQuote> quotes = bookingProviderClientMock.fetchOffers(
                "Paris", LocalDate.now(), LocalDate.now().plusDays(1)
        );

        assertThat(quotes).isNotEmpty();
        assertThat(quotes).allMatch(q -> q.getProvider() == Provider.BOOKING);
        assertThat(quotes).allMatch(q -> q.getCity().equalsIgnoreCase("Paris"));
    }
}
