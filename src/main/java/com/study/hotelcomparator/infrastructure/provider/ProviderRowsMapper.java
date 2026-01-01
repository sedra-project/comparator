package com.study.hotelcomparator.infrastructure.provider;

import com.study.hotelcomparator.infrastructure.provider.dto.ProviderHotelPriceRow;
import com.study.hotelcomparator.domain.model.HotelQuote;
import com.study.hotelcomparator.domain.model.Provider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Component
public class ProviderRowsMapper {
    public List<HotelQuote> toHotelQuotes(String requestedCity,
                                          List<ProviderHotelPriceRow> rows,
                                          Provider provider) {
        return rows.stream()
                .filter(hotelPriceRow -> isNotBlank(hotelPriceRow.getCity()) && equalsIgnoreCase(hotelPriceRow.getCity(), requestedCity))
                .filter(hotelPriceRow -> isNotBlank(hotelPriceRow.getName()))
                .filter(hotelPriceRow -> hotelPriceRow.getPrice() != null)
                .filter(hotelPriceRow -> isNotBlank(hotelPriceRow.getCurrency()))
                .map(hotelPriceRow -> new HotelQuote(
                        hotelPriceRow.getName(),
                        hotelPriceRow.getCity(),
                        provider,
                        hotelPriceRow.getPrice(),
                        hotelPriceRow.getCurrency())
                )
                .collect(Collectors.toList());
    }
}
