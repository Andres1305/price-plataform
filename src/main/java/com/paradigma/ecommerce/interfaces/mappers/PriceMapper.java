package com.paradigma.ecommerce.interfaces.mappers;


import com.paradigma.ecommerce.domain.model.entities.Price;
import com.paradigma.ecommerce.price.openapi.interfaces.rest.dtos.PriceResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PriceMapper {
    List<PriceResponse> toList(List<Price> prices);
}
