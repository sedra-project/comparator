package com.study.hotelcomparator.infrastructure.provider.http;

import com.study.hotelcomparator.infrastructure.provider.dto.ProviderHotelPriceRow;
import com.study.hotelcomparator.domain.model.HotelQuote;
import com.study.hotelcomparator.domain.model.Provider;
import com.study.hotelcomparator.domain.service.ProviderClient;
import com.study.hotelcomparator.infrastructure.provider.ProviderRowsMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Profile("http")
public class AgodaProviderClientHttp implements ProviderClient {
    private final ProviderHttpClient httpClient;
    private final ProviderRowsMapper rowsMapper;
    private final String baseUrl;
    private final String path;

    public AgodaProviderClientHttp(ProviderHttpClient httpClient,
                                   ProviderRowsMapper rowsMapper,
                                   @Value("${providers.base-url}") String baseUrl,
                                   @Value("${providers.agoda-path}") String path) {
        this.httpClient = httpClient;
        this.rowsMapper = rowsMapper;
        this.baseUrl = baseUrl;
        this.path = path;
    }

    @Override
    public List<HotelQuote> fetchOffers(String city,
                                        LocalDate checkIn,
                                        LocalDate checkOut) {
        String url = httpClient.buildUrl(baseUrl, path);
        List<ProviderHotelPriceRow> rows = httpClient.getRows(url);
        return rowsMapper.toHotelQuotes(city, rows, Provider.AGODA);
    }
}
