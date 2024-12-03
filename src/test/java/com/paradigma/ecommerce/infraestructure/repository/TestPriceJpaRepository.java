package com.paradigma.ecommerce.infraestructure.repository;

import com.paradigma.ecommerce.infraestructure.persistence.jpa.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestPriceJpaRepository extends JpaRepository<PriceEntity,Long> {
}
