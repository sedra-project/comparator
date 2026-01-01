package com.study.hotelcomparator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class HotelComparatorApplication {
    private final Environment env;

    public HotelComparatorApplication(Environment env){
        this.env = env;
    }

    @EventListener(org.springframework.boot.context.event.ApplicationReadyEvent.class)
    public void onReady() {
        log.info("Application ready. Active profiles: {}", Arrays.toString(env.getActiveProfiles()));
    }
    public static void main(String[] args) {
        SpringApplication.run(HotelComparatorApplication.class, args);
    }
}
