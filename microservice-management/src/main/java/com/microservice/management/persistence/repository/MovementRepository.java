package com.microservice.management.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.management.persistence.entity.MovementEntity;

public interface MovementRepository extends JpaRepository<MovementEntity, Integer> {}