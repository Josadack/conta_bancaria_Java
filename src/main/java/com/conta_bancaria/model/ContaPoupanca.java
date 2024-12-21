package com.conta_bancaria.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
@DiscriminatorValue("Poupanca") // Valor que será armazenado na coluna do discriminat
public class ContaPoupanca extends Conta{

    private int _aniversario;

    public ContaPoupanca() {
    }

    public ContaPoupanca(UUID numero, int agencia, int tipo, String titular, int saldo) {
        super(numero, agencia, tipo, titular, saldo);
    }

    public int get_aniversario() {
        return _aniversario;
    }

    public void set_aniversario(int _aniversario) {
        this._aniversario = _aniversario;
    }
}
