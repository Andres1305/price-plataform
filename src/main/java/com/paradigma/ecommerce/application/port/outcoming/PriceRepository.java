package com.paradigma.ecommerce.application.port.outcoming;


import com.paradigma.ecommerce.domain.model.entities.Price;

import java.util.List;

public interface PriceRepository {
    List<Price> findPrices(String startDate, Integer productId, Integer brandId);
}
