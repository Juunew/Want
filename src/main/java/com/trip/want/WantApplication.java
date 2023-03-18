package com.trip.want;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WantApplication {

    public static void main(String[] args) {
        SpringApplication.run(WantApplication.class, args);
    }

}
