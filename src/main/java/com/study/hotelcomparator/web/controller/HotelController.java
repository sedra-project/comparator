package com.study.hotelcomparator.web.controller;

import com.study.hotelcomparator.application.dto.HotelDTO;
import com.study.hotelcomparator.application.dto.HotelSearchRequestDTO;
import com.study.hotelcomparator.application.mapper.HotelMapperToDto;
import com.study.hotelcomparator.application.service.HotelComparisonUseCase;
import com.study.hotelcomparator.domain.model.Hotel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    private final HotelComparisonUseCase hotelComparisonUseCase;
    private final HotelMapperToDto hotelMapperToDto;

    public HotelController(HotelComparisonUseCase hotelComparisonUseCase,
                           HotelMapperToDto hotelMapperToDto) {
        this.hotelComparisonUseCase = hotelComparisonUseCase;
        this.hotelMapperToDto = hotelMapperToDto;
    }

    @GetMapping
    public String showSearchForm(Model model) {
        model.addAttribute("form", new HotelSearchRequestDTO());
        model.addAttribute("results", Collections.emptyList());
        model.addAttribute("searched", false);
        return "hotels";
    }

    @PostMapping
    public String search(@Valid @ModelAttribute("form") HotelSearchRequestDTO form,
                         BindingResult bindingResult,
                         Model model) {
        model.addAttribute("searched", true);

        // Erreur de conversion / champs manquants -> on retourne la page avec erreurs
        if (bindingResult.hasErrors()) {
            model.addAttribute("results", Collections.emptyList());
            return "hotels";
        }

        // Validation métier : checkOut > checkIn
        if (form.getCheckIn() != null && form.getCheckOut() != null &&
                !form.getCheckOut().isAfter(form.getCheckIn())) {

            bindingResult.reject("dateRange.invalid", "La date de départ doit être après la date d’arrivée.");
            model.addAttribute("results", Collections.emptyList());
            return "hotels";
        }

        //Si OK -> exécuter le use case
        List<Hotel> hotels = hotelComparisonUseCase.compareHotels(
                form.getCity(), form.getCheckIn(), form.getCheckOut()
        );

        List<HotelDTO> results = hotels.stream()
                .map(hotelMapperToDto::toDto)
                .collect(Collectors.toList());

        model.addAttribute("results", results);
        model.addAttribute("searched", true);
        return "hotels";
    }
}
