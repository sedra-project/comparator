package com.study.hotelcomparator.application.mapper;

import com.study.hotelcomparator.application.dto.HotelDTO;
import com.study.hotelcomparator.application.dto.PriceOfferDTO;
import com.study.hotelcomparator.domain.model.Hotel;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class HotelMapperToDto {

    public HotelDTO toDto(Hotel hotel) {
        HotelDTO dto = new HotelDTO();
        dto.setName(hotel.getName());
        dto.setCity(hotel.getCity());
        dto.setMinPrice(hotel.getMinPrice());

        dto.setOffers(
                hotel.getOffers().stream()
                        .map(o -> {
                            PriceOfferDTO p = new PriceOfferDTO();
                            p.setProvider(o.getProvider().name());
                            p.setPricePerNight(o.getPricePerNight());
                            p.setCurrency(o.getCurrency());
                            return p;
                        })
                        .collect(Collectors.toList())
        );
        return dto;
    }
}
