package com.study.hotelcomparator.web.controller;

import com.study.hotelcomparator.application.dto.HotelDTO;
import com.study.hotelcomparator.application.dto.HotelSearchRequestDTO;
import com.study.hotelcomparator.application.mapper.HotelMapperToDto;
import com.study.hotelcomparator.application.service.HotelComparisonUseCase;
import com.study.hotelcomparator.domain.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    private final HotelComparisonUseCase hotelComparisonUseCase;
    private final HotelMapperToDto hotelMapperToDto;
    @Autowired
    public HotelController(HotelComparisonUseCase hotelComparisonUseCase,
                           HotelMapperToDto hotelMapperToDto) {
        this.hotelComparisonUseCase = hotelComparisonUseCase;
        this.hotelMapperToDto = hotelMapperToDto;
    }

    @GetMapping("/search")
    public String showSearchForm(Model model) {
        model.addAttribute("form", new HotelSearchRequestDTO());
        return "search";
    }

    @PostMapping("/results")
    public String showResults(@RequestParam("city") String city,
                              @RequestParam("checkIn") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
                              @RequestParam("checkOut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
                              Model model) {
        List<Hotel> hotels = hotelComparisonUseCase.compareHotels(city, checkIn, checkOut);
        List<HotelDTO> results = hotels.stream().map(hotelMapperToDto::toDto).collect(Collectors.toList());

        model.addAttribute("city", city);
        model.addAttribute("results", results);
        return "results";
    }
}
