package com.microservice.management.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.management.persistence.entity.MovementEntity;
import com.microservice.management.persistence.repository.MovementRepository;
import com.microservice.management.service.interfaces.IMovementService;
import com.microservice.management.utils.ManageProperties;
import com.microservice.management.web.dto.movement.CreateMovementDTO;
import com.microservice.management.web.dto.movement.MovementDTO;
import com.microservice.management.web.dto.movement.UpdateMovementDTO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MovementServiceImpl implements IMovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MovementDTO> findAll() {

        List<MovementEntity> movements = movementRepository.findAll();
        return movements.stream().map(account -> this.modelMapper.map(account, MovementDTO.class)).collect(Collectors.toList());
    }

    @Override
    public MovementDTO findById(int movementId) {
        MovementEntity movement = this.movementRepository.findById(movementId).orElseThrow(() -> new EntityNotFoundException("Movement not found"));
        return this.modelMapper.map(movement, MovementDTO.class);
    }

    @Override
    public MovementDTO create(CreateMovementDTO movementDTO) {

        MovementEntity movementEntity = this.modelMapper.map(movementDTO, MovementEntity.class);
        // movementEntity.setStatus(true);
        this.movementRepository.save(movementEntity);
        return this.modelMapper.map(movementEntity, MovementDTO.class);
    }

    @Override
    public MovementDTO update(int movementId, UpdateMovementDTO movementDTO) {

        MovementEntity movementEntity = this.movementRepository.findById(movementId).orElseThrow(() -> new EntityNotFoundException("Movement not found"));
        movementEntity = ManageProperties.addMovementProperties(movementDTO, movementEntity);
        MovementEntity updatedMovement = this.movementRepository.save(movementEntity);
        return this.modelMapper.map(updatedMovement, MovementDTO.class);
    }
}