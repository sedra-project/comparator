package com.study.hotelcomparator.application.service;

import com.study.hotelcomparator.domain.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComparatorService {
    public List<Hotel> sortByMinimumPrice(List<Hotel> hotels) {
        return hotels.stream()
                .sorted(Comparator.comparing(Hotel::getMinPrice))
                .collect(Collectors.toList());
    }
}
