package com.study.hotelcomparator.application.service;

import com.study.hotelcomparator.infrastructure.repository.jpa.HotelRepository;
import com.study.hotelcomparator.infrastructure.repository.mapper.HotelMapper;
import com.study.hotelcomparator.domain.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelSearchService {
    private final HotelRepository repository;
    private final HotelMapper mapper;

    public HotelSearchService(HotelRepository repository, HotelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Hotel> findHotelsByCity(String city) {
        return repository.findByCityIgnoreCase(city)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
