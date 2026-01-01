package com.study.hotelcomparator.infrastructure.provider.http;

import com.study.hotelcomparator.infrastructure.provider.dto.ProviderHotelPriceRow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.endsWith;
import static org.apache.commons.lang3.StringUtils.substring;

@Component
@Profile("http")
@Slf4j
public class ProviderHttpClient {
    private static final ParameterizedTypeReference<List<ProviderHotelPriceRow>> ROWS_TYPE =
            new ParameterizedTypeReference<List<ProviderHotelPriceRow>>() {
            };
    private final RestTemplate restTemplate;

    public ProviderHttpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProviderHotelPriceRow> getRows(String url) {
        try {
            ResponseEntity<List<ProviderHotelPriceRow>> response =
                    restTemplate.exchange(url, HttpMethod.GET, null, ROWS_TYPE);

            List<ProviderHotelPriceRow> rows = response.getBody();
            return rows == null ? Collections.emptyList() : rows;

        } catch (HttpStatusCodeException e) {
            // Erreurs HTTP: 400/401/403/404/500...
            log.warn("ProviderHttpClient HTTP error calling {} -> {} {}", url, e.getStatusCode().value(), e.getStatusText());
            return Collections.emptyList();

        } catch (ResourceAccessException e) {
            // Timeout, DNS, connexion refusée...
            log.warn("ProviderHttpClient network error calling {} -> {}", url, e.getMessage());
            return Collections.emptyList();

        } catch (Exception e) {
            // Toute autre exception inattendue
            log.error("ProviderHttpClient unexpected error calling {} -> {}", url, e.getMessage());
            return Collections.emptyList();
        }
    }

    public String buildUrl(String baseUrl, String path) {
        if (endsWith(baseUrl, "/") && endsWith(path, "/")) return substring(baseUrl, 0, baseUrl.length() - 1) + path;
        if (!endsWith(baseUrl, "/") && !endsWith(path, "/")) return baseUrl + "/" + path;
        return baseUrl + path;
    }
}
