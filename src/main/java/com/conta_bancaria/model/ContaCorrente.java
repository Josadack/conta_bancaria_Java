package com.conta_bancaria.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
@DiscriminatorValue("Corrente") // Valor que será armazenado na coluna do discriminator
public class ContaCorrente extends ContaModel {

    @Column(name = "limite")
    private double limite;

    public ContaCorrente() {
       // super();  // Necessário para chamadas ao construtor da superclasse
    }

    public ContaCorrente(UUID id,int numero, int agencia, String titular, int saldo, double limite) {
        super(id,numero, agencia, titular, saldo);
        this.limite = limite;
    }


    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }


}
