package com.microservice.management.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "accountNumber is required")
    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;

    @Column(name = "account_type", columnDefinition = "varchar(40) default 'SAVINGS'")
    private String accountType;

    // @Column(name="account_type")
    // @Enumerated(EnumType.STRING)
    // private AccountTypeEnum accountType;

    @Column(name = "initial_balance", columnDefinition="Decimal(10,2) default '0.00'")
    private Double initialBalance;

    @Column(columnDefinition = "bit(1) default 1")
    private Boolean status;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "client_id")
    @Column(name = "client_id")
    private String clientId;
}
