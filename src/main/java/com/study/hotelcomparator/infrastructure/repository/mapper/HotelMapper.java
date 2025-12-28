package com.study.hotelcomparator.infrastructure.repository.mapper;

import com.study.hotelcomparator.domain.model.Hotel;
import com.study.hotelcomparator.domain.model.PriceOffer;
import com.study.hotelcomparator.infrastructure.repository.entity.HotelEntity;
import com.study.hotelcomparator.infrastructure.repository.entity.PriceOfferEntity;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {
    public Hotel toDomain(HotelEntity entity) {
        Hotel hotel = new Hotel(entity.getId(), entity.getName(), entity.getCity());
        entity.getOffers().forEach(offer ->
                hotel.addOffer(new PriceOffer(
                        offer.getProvider(),
                        offer.getPricePerNight(),
                        offer.getCurrency()
                ))
        );
        return hotel;
    }

    public HotelEntity toEntity(Hotel domain) {
        HotelEntity entity = new HotelEntity();
        entity.setName(domain.getName());
        entity.setCity(domain.getCity());
        domain.getOffers().forEach(o -> {
            PriceOfferEntity pe = new PriceOfferEntity();
            pe.setProvider(o.getProvider());
            pe.setPricePerNight(o.getPricePerNight());
            pe.setCurrency(o.getCurrency());
            entity.addOffer(pe);
        });
        return entity;
    }
}
