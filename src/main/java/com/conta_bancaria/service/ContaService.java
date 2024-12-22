package com.conta_bancaria.service;

import com.conta_bancaria.repository.ContaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository){
        this.contaRepository = contaRepository;
    }
}
