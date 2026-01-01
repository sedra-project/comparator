package com.study.hotelcomparator.infrastructure.provider.mockclient;

import com.study.hotelcomparator.infrastructure.provider.dto.ProviderHotelPriceRow;
import com.study.hotelcomparator.infrastructure.provider.mock.MockProviderFileReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("mock")
public class MockProviderFileReaderTest {
    @Autowired
    private MockProviderFileReader reader;

    @Test
    void should_read_rows_from_resource() {
        List<ProviderHotelPriceRow> rows = reader.readRows("/mock/booking.json");
        assertThat(rows).isNotNull();
        assertThat(rows.get(0).getName()).isNotBlank();
    }
}
