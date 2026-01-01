package com.study.hotelcomparator.infrastructure.provider.mock;

import com.study.hotelcomparator.infrastructure.provider.dto.ProviderHotelPriceRow;
import com.study.hotelcomparator.domain.model.HotelQuote;
import com.study.hotelcomparator.domain.model.Provider;
import com.study.hotelcomparator.domain.service.ProviderClient;
import com.study.hotelcomparator.infrastructure.provider.ProviderRowsMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Profile("mock")
public class AgodaProviderClientMock implements ProviderClient {
    private final ProviderRowsMapper providerRowsMapper;
    private final MockProviderFileReader fileReader;

    private static final String RESOURCE = "/mock/agoda.json";

    public AgodaProviderClientMock(ProviderRowsMapper providerRowsMapper,
                                   MockProviderFileReader fileReader) {
        this.providerRowsMapper = providerRowsMapper;
        this.fileReader = fileReader;
    }

    @Override
    public List<HotelQuote> fetchOffers(String city,
                                        LocalDate checkIn,
                                        LocalDate checkOut) {
        List<ProviderHotelPriceRow> rows = fileReader.readRows(RESOURCE);
        return providerRowsMapper.toHotelQuotes(city, rows, Provider.AGODA);
    }
}
