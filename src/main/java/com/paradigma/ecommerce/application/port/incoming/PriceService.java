package com.paradigma.ecommerce.application.port.incoming;



import com.paradigma.ecommerce.domain.model.entities.Price;

import java.util.List;

public interface PriceService {

    List<Price> get(String startDate, Integer productId, Integer brandId);
}
