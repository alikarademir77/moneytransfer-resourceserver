package com.westerunion.moneytransferpoc.controller;

import com.westerunion.moneytransferpoc.model.Transaction;
import com.westerunion.moneytransferpoc.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transfer/api/v1")
@Slf4j
public class MoneyTransferTransactionsController {

    private final TransactionRepository transactionRepository;

    public MoneyTransferTransactionsController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @PreAuthorize("hasAuthority('SCOPE_transaction')")
    @GetMapping("/transactions")
    public List<Transaction> allTransactionsByUser(@RequestParam(required = false) String email) {
        log.info("Retrieving transactions for {}", email);

        return
                transactionRepository.findAllByEmail(email);
    }

    @PreAuthorize("hasAuthority('SCOPE_transaction')")
    @PostMapping("/transactions")
    public Transaction createTransaction(@Valid @RequestBody Transaction transaction) {
        log.info("Creating new transactions for user {}", transaction.getEmail());

        transaction.setId(UUID.randomUUID());
        transaction.setCreated(Instant.now());

        transactionRepository.insert(transaction);

        return transaction;
    }

}
