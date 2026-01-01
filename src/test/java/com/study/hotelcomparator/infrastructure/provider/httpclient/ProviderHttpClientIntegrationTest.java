package com.study.hotelcomparator.infrastructure.provider.httpclient;

import com.study.hotelcomparator.infrastructure.provider.dto.ProviderHotelPriceRow;
import com.study.hotelcomparator.infrastructure.provider.http.ProviderHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProviderHttpClientIntegrationTest {

    private MockWebServer server;
    private ProviderHttpClient httpClient;

    @BeforeEach
    void setup() throws IOException {
        server = new MockWebServer();
        server.start();

        httpClient = new ProviderHttpClient(new RestTemplate());
    }

    @AfterEach
    void tearDown() throws IOException {
        server.shutdown();
    }

    @Test
    void should_parse_rows_from_http() {
        String json = "[{\"name\":\"Central Stay\",\"city\":\"Paris\",\"price\":162,\"currency\":\"EUR\"}]";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .addHeader("Content-Type", "application/json")
                .setBody(json));

        String url = server.url("/provider/agoda").toString();

        List<ProviderHotelPriceRow> rows = httpClient.getRows(url);

        assertThat(rows.get(0).getName()).isEqualTo("Central Stay");
        assertThat(rows.get(0).getCity()).isEqualTo("Paris");
    }
}
