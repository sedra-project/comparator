package com.study.hotelcomparator.infrastructure.repository.jpa;

import com.study.hotelcomparator.infrastructure.repository.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    List<HotelEntity> findByCityIgnoreCase(String city);
}
