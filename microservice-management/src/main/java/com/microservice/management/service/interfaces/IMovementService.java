package com.microservice.management.service.interfaces;

import java.util.List;

import com.microservice.management.persistence.entity.MovementEntity;

public interface IMovementService {
    public List<MovementEntity> findAll();
    public MovementEntity findById(int movementeId);
    public MovementEntity create(MovementEntity movement);
    public MovementEntity update(MovementEntity movement);
}
