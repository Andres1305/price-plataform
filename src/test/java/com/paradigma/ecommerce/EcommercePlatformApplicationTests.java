package com.paradigma.ecommerce;

import com.paradigma.ecommerce.infraestructure.repository.TestPriceJpaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcommercePlatformApplicationTests {

    @Autowired
    private TestPriceJpaRepository testPriceJpaRepository;
    @Test
    void contextLoads() {
    }

    @AfterEach
    public void clear() {
        testPriceJpaRepository.deleteAll();
    }

}
