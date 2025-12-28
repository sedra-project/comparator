package com.study.hotelcomparator.infrastructure.repository;

import com.study.hotelcomparator.infrastructure.repository.entity.HotelEntity;
import com.study.hotelcomparator.infrastructure.repository.jpa.HotelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HotelRepositoryTest {
    @Autowired
    HotelRepository repo;
    @Test
    public void should_find_hotel_by_city() {
        List<HotelEntity> hotels = repo.findByCityIgnoreCase("paris");
        assertThat(hotels).isNotNull();
        assertThat(hotels.get(0).getCity()).isEqualTo("Paris");
    }

    @Test
    void should_find_hotels_by_city() {
        // GIVEN
        HotelEntity parisHotel = new HotelEntity();
        parisHotel.setName("Sunrise Palace");
        parisHotel.setCity("Paris");

        HotelEntity niceHotel = new HotelEntity();
        niceHotel.setName("Blue Ocean");
        niceHotel.setCity("Nice");

        repo.saveAll(Arrays.asList(parisHotel, niceHotel));

        // WHEN
        List<HotelEntity> found = repo.findByCityIgnoreCase("paris");

        // THEN
        assertThat(found).isNotNull();
        assertThat(found.get(0).getName()).isEqualTo("Sunrise Palace");
    }
}
