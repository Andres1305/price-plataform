package com.paradigma.ecommerce.application.service;


import com.paradigma.ecommerce.application.port.incoming.PriceService;
import com.paradigma.ecommerce.application.port.outcoming.PriceRepository;
import com.paradigma.ecommerce.domain.model.entities.Price;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class PriceServiceImpl  implements PriceService {

    private final PriceRepository priceRepository;
    @Override
    public List<Price> get(String startDate, Integer productId, Integer brandId) {
        return priceRepository.findPrices(startDate,productId,brandId);
    }
}
