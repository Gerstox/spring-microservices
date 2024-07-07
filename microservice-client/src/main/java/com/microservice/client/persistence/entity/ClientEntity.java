package com.microservice.client.persistence.entity;

import com.microservice.client.persistence.enumeration.GenderEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "clients")
// public class ClientEntity extends PersonEntity {
public class ClientEntity {

    // Person Class Properties
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String identification;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    GenderEnum gender;

    private Integer age;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;
    // End Person Class Properties

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "boolean default true")
    private Boolean status;
}
