package com.microservice.management.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.management.persistence.entity.MovementEntity;
import com.microservice.management.persistence.repository.MovementRepository;
import com.microservice.management.service.interfaces.IMovementService;

@Service
public class MovementServiceImpl implements IMovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Override
    public List<MovementEntity> findAll() {
        return movementRepository.findAll();
    }

    @Override
    public MovementEntity findById(int movementId) {
        return movementRepository.findById(movementId).orElseThrow();
    }

    @Override
    public MovementEntity create(MovementEntity movement) {
        return movementRepository.save(movement);
    }

    @Override
    public MovementEntity update(MovementEntity movement) {
        MovementEntity movementDB = findById(movement.getId());
        if (movementDB == null) {
            return null;
        }
        
        // TODO: Que no guarde las propiedades nulas
        return movementRepository.save(movement);
    }
}