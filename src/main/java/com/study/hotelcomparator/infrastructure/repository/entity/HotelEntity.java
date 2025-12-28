package com.study.hotelcomparator.infrastructure.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotels")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PriceOfferEntity> offers = new ArrayList<>();

    public HotelEntity() {
    }

    public HotelEntity(Long id, String name, String city, List<PriceOfferEntity> offers) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.offers = offers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<PriceOfferEntity> getOffers() {
        return offers;
    }

    public void setOffers(List<PriceOfferEntity> offers) {
        this.offers = offers;
    }

    public void addOffer(PriceOfferEntity offer) {
        offers.add(offer);
        offer.setHotel(this);
    }

    @Override
    public String toString() {
        return "HotelEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", offers=" + offers +
                '}';
    }
}
