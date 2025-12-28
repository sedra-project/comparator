package com.study.hotelcomparator.application.dto;

import java.time.LocalDate;

public class HotelSearchRequestDTO {
    private String city;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public HotelSearchRequestDTO(String city, LocalDate checkIn, LocalDate checkOut) {
        this.city = city;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public HotelSearchRequestDTO() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
}
