package com.westerunion.moneytransferpoc.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@Table("Transaction")
public class Transaction {

    @PrimaryKey
    @Column("id")
    private UUID id;

    @NotBlank(message = "email is mandatory")
    @Column("email")
    private String email;

    @NotBlank(message = "source account is mandatory")
    @Column("from_account")
    private String fromAccount;

    @NotBlank(message = "target account is mandatory")
    @Column("to_account")
    private String toAccount;

    @NotNull(message = "amount is mandatory")
    @Column("amount")
    private BigDecimal amount;

    @NotNull(message = "Currency is mandatory")
    @Column("currency")
    private Currency currency;

    @Column("created")
    private Instant created;
}
