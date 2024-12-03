package com.paradigma.ecommerce;

import com.paradigma.ecommerce.infraestructure.persistence.repository.PriceJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommercePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommercePlatformApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PriceJpaRepository priceJpaRepository){
        return args -> {
            final var listPrices= priceJpaRepository.findAll();
            listPrices.forEach(System.out::println);
        };
    }
}