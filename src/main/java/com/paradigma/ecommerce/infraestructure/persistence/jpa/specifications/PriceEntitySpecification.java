package com.paradigma.ecommerce.infraestructure.persistence.jpa.specifications;


import com.paradigma.ecommerce.infraestructure.persistence.jpa.entities.PriceEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class PriceEntitySpecification {

    public static Specification<PriceEntity> getUsers(String startDate, Integer productId, Integer brandId)  {
           return (root, query, criteriaBuilder) -> {
               List<Predicate> predicates = new ArrayList<>();

               if (startDate != null) {
                   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
                   LocalDateTime startLocalDateTime = LocalDateTime.parse(startDate, formatter);
                   predicates.add(criteriaBuilder.and(
                           criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.literal(startLocalDateTime), root.get("startDate")),
                           criteriaBuilder.lessThanOrEqualTo(criteriaBuilder.literal(startLocalDateTime), root.get("endDate"))
                   ));
               }

               if(productId!=null ){
                   predicates.add(criteriaBuilder.equal(root.get("productId"), productId.longValue()));
               }

               if(brandId!=null ){
                   predicates.add(criteriaBuilder.equal(root.get("brandId"), brandId.longValue()));
               }


               return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
           };
    }


}
