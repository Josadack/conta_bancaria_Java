package com.conta_bancaria.service;

import com.conta_bancaria.model.ContaCorrente;
import com.conta_bancaria.model.ContaModel;
import com.conta_bancaria.model.ContaPoupanca;
import com.conta_bancaria.repository.ContaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContaService {
    final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository){
        this.contaRepository = contaRepository;
    }

    @Transactional
    public Object save(ContaCorrente contaCorrente) {
        return contaRepository.save(contaCorrente);
    }

    @Transactional
    public Object save(ContaPoupanca contaPoupanca) {
        return contaRepository.save(contaPoupanca);
    }

    public boolean existsByNumero(int numero, String titular) {
        return contaRepository.existsByNumero(numero);
    }

    public List<ContaModel> findAll() {
        return contaRepository.findAll();
    }

    public Optional<ContaModel> findById(UUID id) {
        return contaRepository.findById(id);
    }

    @Transactional
    public void delete(ContaModel contaModel) {
         contaRepository.delete(contaModel);
    }
}



