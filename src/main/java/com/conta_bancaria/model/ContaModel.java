package com.conta_bancaria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_Conta")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //
@DiscriminatorColumn(name = "tipo_conta", discriminatorType = DiscriminatorType.STRING)
public abstract class ContaModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 30 )
    private int numero;

    @Column(nullable = false, length = 5)
    private int agencia;

    @Column(nullable = false, length = 70)
    private String titular;

    @Column(nullable = false)
    private int saldo;

    // Construtor sem argumentos é necessário para JPA
    public ContaModel() {
    }

    public ContaModel(UUID id ,int numero, int agencia, String titular, int saldo) {
        this.id = id;
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
