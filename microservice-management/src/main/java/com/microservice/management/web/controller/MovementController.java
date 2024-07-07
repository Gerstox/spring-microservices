package com.microservice.management.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.management.persistence.entity.MovementEntity;
import com.microservice.management.service.interfaces.IMovementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movimientos")
public class MovementController {
    @Autowired
    private IMovementService movementService;

    @GetMapping
    public ResponseEntity<List<MovementEntity>> findAll() {
        List<MovementEntity> movements = movementService.findAll();
        if (movements.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movements);
    }

    @GetMapping("/{movementId}")
    public ResponseEntity<MovementEntity> findById(@PathVariable("movementId") int movementId) {
        MovementEntity movement = movementService.findById(movementId);
        if (movement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movement);
    }

    @PostMapping
    public ResponseEntity<MovementEntity> create(@Valid @RequestBody MovementEntity movement) {
        MovementEntity newMovement = movementService.create(movement);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMovement);
    }

    @PutMapping("/{movementId}")
    public ResponseEntity<MovementEntity> update(
        @PathVariable("movementId") int movementId,
        @RequestBody MovementEntity movement) {

        movement.setId(movementId);
        MovementEntity movementDB = movementService.update(movement);
        if (movementDB == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movementDB);
    }

    // TODO: Centralizar
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
