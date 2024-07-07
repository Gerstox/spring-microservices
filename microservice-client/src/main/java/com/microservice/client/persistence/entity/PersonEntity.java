package com.microservice.client.persistence.entity;

import com.microservice.client.persistence.enumeration.GenderEnum;

import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String identification;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    GenderEnum gender;

    private Integer age;
    private String address;
    private String phone;
}
