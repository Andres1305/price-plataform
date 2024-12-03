package com.paradigma.ecommerce.infraestructure.persistence.jpa.mappers;


import com.paradigma.ecommerce.domain.model.entities.Price;
import com.paradigma.ecommerce.infraestructure.persistence.jpa.entities.PriceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PriceEntityMapper {
    List<Price> toList(List<PriceEntity> priceEntities);
}
