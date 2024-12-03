package com.paradigma.ecommerce.domain.model.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Price {


    private long id;

    private Integer brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private  Integer priceList;

    private Integer productId;

    private Integer priority;

    private Double price;

    private String currency;
}
