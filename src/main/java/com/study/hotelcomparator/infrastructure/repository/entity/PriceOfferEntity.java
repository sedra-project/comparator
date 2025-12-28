package com.study.hotelcomparator.infrastructure.repository.entity;

import com.study.hotelcomparator.domain.model.Provider;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "price_offers")
public class PriceOfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Provider provider;
    private BigDecimal pricePerNight;
    private String currency;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    public PriceOfferEntity() {
    }

    public PriceOfferEntity(Long id, Provider provider, BigDecimal pricePerNight, String currency, HotelEntity hotel) {
        this.id = id;
        this.provider = provider;
        this.pricePerNight = pricePerNight;
        this.currency = currency;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "PriceOfferEntity{" +
                "id=" + id +
                ", provider=" + provider +
                ", pricePerNight=" + pricePerNight +
                ", currency='" + currency + '\'' +
                ", hotel=" + hotel +
                '}';
    }
}
