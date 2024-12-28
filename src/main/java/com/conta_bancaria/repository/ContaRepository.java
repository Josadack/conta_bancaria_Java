package com.conta_bancaria.repository;

import com.conta_bancaria.model.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Repository
@Service
public interface ContaRepository extends JpaRepository<ContaModel, UUID>{
    boolean existsByNumero(int numero);

}
