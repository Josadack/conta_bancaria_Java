package com.conta_bancaria.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
@DiscriminatorValue("Corrente") // Valor que será armazenado na coluna do discriminator
public class ContaCorrente extends Conta{

    private double _limite;

    public ContaCorrente() {
        super();  // Necessário para chamadas ao construtor da superclasse
    }

    public ContaCorrente(UUID numero, int agencia, int tipo, String titular, int saldo, double limite) {
        super(numero, agencia, tipo, titular, saldo);
        this._limite = limite;
    }


    public double get_limite() {
        return _limite;
    }

    public void set_limite(double limite) {
        this._limite = limite;
    }


}
