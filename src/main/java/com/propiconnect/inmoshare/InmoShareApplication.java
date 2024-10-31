package com.propiconnect.inmoshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InmoShareApplication {

    public static void main(String[] args) {
        SpringApplication.run(InmoShareApplication.class, args);
    }

}
