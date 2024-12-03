package com.paradigma.ecommerce.infraestructure.persistence.jpa.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "price")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="brand_id")
    private Integer brandId;

    @Column(name="start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "price_list")
    private  Integer priceList;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "price")
    private Double price;

    @Column(name = "currency")
    private String currency;

}
