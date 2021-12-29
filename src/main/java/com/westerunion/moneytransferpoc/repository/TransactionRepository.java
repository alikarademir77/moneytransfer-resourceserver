package com.westerunion.moneytransferpoc.repository;

import com.westerunion.moneytransferpoc.model.Transaction;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends CassandraRepository<Transaction, UUID> {

    @AllowFiltering
    List<Transaction> findAllByEmail(String email);
}
