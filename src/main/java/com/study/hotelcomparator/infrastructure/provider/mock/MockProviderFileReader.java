package com.study.hotelcomparator.infrastructure.provider.mock;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.hotelcomparator.infrastructure.provider.dto.ProviderHotelPriceRow;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
@Component
@Profile("mock")
public class MockProviderFileReader {

    private static final TypeReference<List<ProviderHotelPriceRow>> ROWS_TYPE =
            new TypeReference<List<ProviderHotelPriceRow>>() {};

    private final ObjectMapper objectMapper;

    public MockProviderFileReader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<ProviderHotelPriceRow> readRows(String classpathResource) {
        try (InputStream is = getClass().getResourceAsStream(classpathResource)) {
            if (is == null)
                throw new IllegalArgumentException("Resource not found: " + classpathResource);

            return objectMapper.readValue(is, ROWS_TYPE);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read " + classpathResource, e);
        }
        }
}
