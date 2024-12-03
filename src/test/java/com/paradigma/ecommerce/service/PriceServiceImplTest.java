package com.paradigma.ecommerce.service;


import com.paradigma.ecommerce.application.port.outcoming.PriceRepository;
import com.paradigma.ecommerce.application.service.PriceServiceImpl;
import com.paradigma.ecommerce.domain.model.entities.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

    public static final LocalDateTime NOW = LocalDateTime.now();
    @Mock
    private PriceRepository priceRepository;

    private PriceServiceImpl priceService;


    @BeforeEach
    void setUp(){
        priceService=new PriceServiceImpl(priceRepository);
    }

    Price priceExpected = Price.builder()
            .id(1L)
            .startDate(NOW)
            .endDate(NOW)
            .brandId(1)
            .priority(1)
            .productId(1)
            .currency("EN")
            .build();

    @Test
    void return_list_of_price(){
        //given
        //when
        when(priceRepository.findPrices(priceExpected.getStartDate().toString(),priceExpected.getProductId(),priceExpected.getBrandId()))
                .thenReturn(List.of(priceExpected));

        final var priceCurrent = priceService.get(priceExpected.getStartDate().toString(),priceExpected.getProductId(),priceExpected.getBrandId());
        //then
        assertThat(priceCurrent.get(0)).isEqualTo(priceExpected);
        verify(priceRepository).findPrices(priceExpected.getStartDate().toString(),priceExpected.getProductId(),priceExpected.getBrandId());
        verifyNoMoreInteractions(priceRepository);
    }

}