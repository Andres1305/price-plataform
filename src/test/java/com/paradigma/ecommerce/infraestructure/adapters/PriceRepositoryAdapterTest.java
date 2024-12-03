package com.paradigma.ecommerce.infraestructure.adapters;
import com.paradigma.ecommerce.infraestructure.persistence.jpa.mappers.PriceEntityMapperImpl;
import com.paradigma.ecommerce.infraestructure.persistence.jpa.entities.PriceEntity;
import com.paradigma.ecommerce.infraestructure.persistence.repository.PriceJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PriceRepositoryAdapterTest {

    public static final LocalDateTime NOW = LocalDateTime.now();
    private PriceRepositoryAdapter priceRepositoryAdapter;

    @Mock
    private PriceJpaRepository priceJpaRepository;

    private PriceEntityMapperImpl priceEntityMapper= new PriceEntityMapperImpl();


    PriceEntity priceEntityExpected = PriceEntity.builder()
            .id(1L)
            .startDate(NOW)
            .endDate(NOW)
            .brandId(1)
            .priority(1)
            .productId(1)
            .currency("EN")
            .build();

    @BeforeEach
    void setUp(){
        priceRepositoryAdapter= new PriceRepositoryAdapter(priceJpaRepository,priceEntityMapper);
    }

    @Test
    void test_find_prices(){
        //given
        List<PriceEntity> priceEntityList= new ArrayList<>();
        priceEntityList.add(priceEntityExpected);
        //when
        when(priceJpaRepository.findAll(any(Specification.class))).thenReturn(priceEntityList);
        final var listPrices=priceRepositoryAdapter.findPrices(priceEntityExpected.getStartDate().toString(),priceEntityExpected.getProductId(),priceEntityExpected.getBrandId());

        //then
        assertEquals( priceEntityMapper.toList(priceEntityList), listPrices);
        verify(priceJpaRepository).findAll(any(Specification.class));
        verifyNoMoreInteractions(priceJpaRepository);

    }

}