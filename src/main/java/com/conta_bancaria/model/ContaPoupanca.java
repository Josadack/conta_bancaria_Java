package com.conta_bancaria.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
@DiscriminatorValue("Poupanca") // Valor que será armazenado na coluna do discriminat
public class ContaPoupanca extends ContaModel {

    @Column(name = "aniversario")
    private int aniversario;

    public ContaPoupanca() {
    }

    public ContaPoupanca(UUID id, int numero, int agencia, String titular, int saldo) {
        super(id, numero, agencia, titular, saldo);
    }

    public int getAniversario() {
        return aniversario;
    }

    public void setAniversario(int aniversario) {
        this.aniversario = aniversario;
    }
}
