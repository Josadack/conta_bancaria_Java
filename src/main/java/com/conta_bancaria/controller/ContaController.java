package com.conta_bancaria.controller;

import com.conta_bancaria.dto.ContaDto;
import com.conta_bancaria.model.ContaCorrente;
import com.conta_bancaria.model.ContaModel;
import com.conta_bancaria.model.ContaPoupanca;
import com.conta_bancaria.service.ContaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3000)
@RequestMapping("/contas")
public class ContaController {

    final ContaService contaService;

    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }

    //CREATE - Criar ContaCorrente
    @PostMapping("/corrente")
    public ResponseEntity<Object> criaContaCC(@RequestBody @Valid ContaDto contaDto){
        if(contaService.existsByNumero(contaDto.numero(), contaDto.titular())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Você precisa informar o Número da Conta, " +
                                                                 "\nPorque esse número pertence a outro titular: ");
        }
        var contaCorrente = new ContaCorrente();
        BeanUtils.copyProperties(contaDto, contaCorrente);
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.save(contaCorrente));
    }

    //CREATE - Criar ContaPoupança
    @PostMapping("/poupanca")
    public ResponseEntity<Object> criaContaCP(@RequestBody @Valid ContaDto contaDto){
        if(contaService.existsByNumero(contaDto.numero(), contaDto.titular())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Você precisa informar o Número da Conta, " +
                                                                   "\nPorque esse número pertence ao: "+ contaDto.titular());
        }
        var contaPoupanca = new ContaPoupanca();
        BeanUtils.copyProperties(contaDto, contaPoupanca);
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.save(contaPoupanca));
    }

    //Ler todas Contas
    @GetMapping
    public ResponseEntity<List<ContaModel>> lerTodasContas(){
        return ResponseEntity.status(HttpStatus.OK).body(contaService.findAll());
    }


    //Ler Conta específica
    @GetMapping("/{id}")
    public ResponseEntity<Object> lerContaEspecifica(@PathVariable (value = "id") UUID id){
        Optional<ContaModel> contaModel = contaService.findById(id);
        if(!contaModel.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(contaModel.get());
    }


    //Atulizar conta
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarConta(@PathVariable (value = "id") UUID id, @RequestBody @Valid ContaDto contaDto) {
        Optional<ContaModel> contaModelOptional = contaService.findById(id);
        if (!contaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada. ⛓️‍💥");
        }
        // Aqui pegamos a conta que já existe
        ContaModel contaExistente = contaModelOptional.get();

        // Verifica o tipo da conta
        if (contaExistente instanceof ContaCorrente) {
            ContaCorrente contaCorrente = (ContaCorrente) contaExistente;
            BeanUtils.copyProperties(contaDto, contaCorrente, "id"); // Copia dados do DTO e não sobrescreve o ID
            return ResponseEntity.ok(contaService.save(contaCorrente));

        } else if (contaExistente instanceof ContaPoupanca) {
            ContaPoupanca contaPoupanca = (ContaPoupanca) contaExistente;
            BeanUtils.copyProperties(contaDto, contaPoupanca, "id"); // Copia dados do DTO e não sobrescreve o ID
            return ResponseEntity.ok(contaService.save(contaPoupanca));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Tipo de conta desconhecido. ☠️");
        }
    }


    //Deletar Conta específica
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarContaEspecifica(@PathVariable (value = "id") UUID id){
        Optional<ContaModel> contaModel = contaService.findById(id);
        if(!contaModel.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Conta não encontrada! ️‍⛓️‍💥 ");
        }
        contaService.delete(contaModel.get());
        return ResponseEntity.status(HttpStatus.OK).body("Conta deletada com sucesso! ");
    }

}
