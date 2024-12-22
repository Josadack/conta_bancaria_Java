package com.conta_bancaria.controller;

import com.conta_bancaria.service.ContaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContaController {

    final ContaService contaService;

    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }
}
