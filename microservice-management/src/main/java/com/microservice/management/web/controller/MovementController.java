package com.microservice.management.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.management.service.interfaces.IMovementService;
import com.microservice.management.web.dto.movement.CreateMovementDTO;
import com.microservice.management.web.dto.movement.MovementDTO;
import com.microservice.management.web.dto.movement.UpdateMovementDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movimientos")
public class MovementController {
    @Autowired
    private IMovementService movementService;

    @GetMapping
    public ResponseEntity<List<MovementDTO>> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body(this.movementService.findAll());
    }

    @GetMapping("/{movementId}")
    public ResponseEntity<MovementDTO> findById(@PathVariable("movementId") int movementId) {

        MovementDTO movement = this.movementService.findById(movementId);
        return ResponseEntity.status(HttpStatus.OK).body(movement);
    }

    @PostMapping
    public ResponseEntity<MovementDTO> create(@Valid @RequestBody CreateMovementDTO movementDTO) {
        
        this.movementService.create(movementDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{movementId}")
    public ResponseEntity<MovementDTO> update(
        @PathVariable("movementId") int movementId,
        @RequestBody UpdateMovementDTO movementDTO) {

        return ResponseEntity.status(HttpStatus.OK).body(this.movementService.update(movementId, movementDTO));
    }
}
