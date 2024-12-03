package com.paradigma.ecommerce.infraestructure.persistence.repository;


import com.paradigma.ecommerce.infraestructure.persistence.jpa.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long>, JpaSpecificationExecutor<PriceEntity> {
}
