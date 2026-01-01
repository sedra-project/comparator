package com.study.hotelcomparator.application.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Setter
@Getter
public class HotelSearchRequestDTO {
    @NotBlank(message = "La ville est obligatoire.")
    private String city;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkIn;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkOut;

    public HotelSearchRequestDTO(String city, LocalDate checkIn, LocalDate checkOut) {
        this.city = city;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public HotelSearchRequestDTO() {
    }

}
