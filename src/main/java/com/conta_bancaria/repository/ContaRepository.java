package com.conta_bancaria.repository;

import com.conta_bancaria.model.Conta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ContaRepository extends CrudRepository<Conta, UUID> {
}
