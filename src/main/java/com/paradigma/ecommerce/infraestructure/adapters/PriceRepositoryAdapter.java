package com.paradigma.ecommerce.infraestructure.adapters;


import com.paradigma.ecommerce.application.port.outcoming.PriceRepository;
import com.paradigma.ecommerce.domain.model.entities.Price;
import com.paradigma.ecommerce.infraestructure.persistence.jpa.entities.PriceEntity;
import com.paradigma.ecommerce.infraestructure.persistence.jpa.mappers.PriceEntityMapper;
import com.paradigma.ecommerce.infraestructure.persistence.jpa.specifications.PriceEntitySpecification;
import com.paradigma.ecommerce.infraestructure.persistence.repository.PriceJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class PriceRepositoryAdapter implements PriceRepository {

    private final PriceJpaRepository priceJpaRepository;

    private final PriceEntityMapper priceEntityMapper;

    @Override
    public List<Price> findPrices(String startDate, Integer productId, Integer brandId) {
        Specification<PriceEntity> priceEntitySpecification= PriceEntitySpecification.getUsers(startDate,productId,brandId);
        return priceEntityMapper.toList(this.priceJpaRepository.findAll(priceEntitySpecification));
    }
}
