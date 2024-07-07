package com.microservice.management.service.interfaces;

import java.util.List;

import com.microservice.management.web.dto.movement.CreateMovementDTO;
import com.microservice.management.web.dto.movement.MovementDTO;
import com.microservice.management.web.dto.movement.UpdateMovementDTO;

public interface IMovementService {
    public List<MovementDTO> findAll();
    public MovementDTO findById(int movementeId);
    public MovementDTO create(CreateMovementDTO movementDTO);
    public MovementDTO update(int movementId, UpdateMovementDTO movementDTO);
}
