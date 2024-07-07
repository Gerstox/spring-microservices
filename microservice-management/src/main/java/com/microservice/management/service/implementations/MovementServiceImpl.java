package com.microservice.management.service.implementations;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.management.persistence.entity.AccountEntity;
import com.microservice.management.persistence.entity.MovementEntity;
import com.microservice.management.persistence.repository.MovementRepository;
import com.microservice.management.service.interfaces.IAccountService;
import com.microservice.management.service.interfaces.IMovementService;
import com.microservice.management.utils.ManageProperties;
import com.microservice.management.web.dto.account.AccountDTO;
import com.microservice.management.web.dto.movement.CreateMovementDTO;
import com.microservice.management.web.dto.movement.MovementDTO;
import com.microservice.management.web.dto.movement.UpdateMovementDTO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MovementServiceImpl implements IMovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MovementDTO> findAll() {

        List<MovementEntity> movements = movementRepository.findAll();
        return movements.stream().map(movement -> this.modelMapper.map(movement, MovementDTO.class)).collect(Collectors.toList());
    }

    @Override
    public MovementDTO findById(int movementId) {
        MovementEntity movement = this.movementRepository.findById(movementId).orElseThrow(() -> new EntityNotFoundException("Movement not found"));
        return this.modelMapper.map(movement, MovementDTO.class);
    }

    @Override
    public void create(CreateMovementDTO movementDTO) {

        AccountDTO accountDTO = this.accountService.findById(movementDTO.getAccountId());
        Double finalAmount = accountService.updateBalance(accountDTO.getId(), movementDTO.getValue());
        
        LocalDateTime today = LocalDateTime.now();
        AccountEntity account = this.modelMapper.map(accountDTO, AccountEntity.class);


        MovementEntity movementEntity = MovementEntity.builder()
            .date(today)
            .movementType(movementDTO.getMovementType())
            .value(movementDTO.getValue())
            .balance(finalAmount)
            .account(account)
            .build();

        movementRepository.save(movementEntity);
    }

    @Override
    public MovementDTO update(int movementId, UpdateMovementDTO movementDTO) {

        MovementEntity movementEntity = this.movementRepository.findById(movementId).orElseThrow(() -> new EntityNotFoundException("Movement not found"));
        movementEntity = ManageProperties.addMovementProperties(movementDTO, movementEntity);
        MovementEntity updatedMovement = this.movementRepository.save(movementEntity);
        return this.modelMapper.map(updatedMovement, MovementDTO.class);
    }
}