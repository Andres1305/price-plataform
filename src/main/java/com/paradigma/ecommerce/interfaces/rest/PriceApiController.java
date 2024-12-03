package com.paradigma.ecommerce.interfaces.rest;


import com.paradigma.ecommerce.application.port.incoming.PriceService;
import com.paradigma.ecommerce.interfaces.mappers.PriceMapper;
import com.paradigma.ecommerce.price.openapi.interfaces.rest.PriceApi;
import com.paradigma.ecommerce.price.openapi.interfaces.rest.dtos.PriceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PriceApiController implements PriceApi {

    private final PriceService priceService;

    private final PriceMapper priceMapper;

    @Override
    public ResponseEntity<List<PriceResponse>> getPrices(String applyDate, Integer productId, Integer brandId) {
        final var listPriceResponse=priceMapper.toList(priceService.get(applyDate, productId, brandId));
        return ResponseEntity.ok().body(listPriceResponse);
    }
}
