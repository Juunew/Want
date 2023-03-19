package com.trip.want;

import com.trip.want.common.config.SessionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.servlet.http.HttpSessionListener;

@EnableJpaAuditing
@SpringBootApplication
public class WantApplication {

    public static void main(String[] args) {
        SpringApplication.run(WantApplication.class, args);
    }

    @Bean
    public HttpSessionListener httpSessionListener() {
        return new SessionListener();
    }

}
