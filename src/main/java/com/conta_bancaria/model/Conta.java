package com.conta_bancaria.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.rmi.server.UID;
import java.util.UUID;

@Entity
@Table(name = "TB_Conta")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Estrutura de herança
@DiscriminatorColumn(name = "tipo_conta", discriminatorType = DiscriminatorType.STRING)
public abstract class Conta implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID _numero;
    private int _agencia;
    private int _tipo;
    private String _titular;
    private int _saldo;

    // Construtor sem argumentos é necessário para JPA
    public Conta() {
    }

    public Conta(UUID numero, int agencia, int tipo, String titular, int saldo) {
        this._numero = numero;
        this._agencia = agencia;
        this._tipo = tipo;
        this._titular = titular;
        this._saldo = saldo;
    }

    public UUID get_numero() {
        return _numero;
    }

    public void set_numero(UUID _numero) {
        this._numero = _numero;
    }

    public int get_agencia() {
        return _agencia;
    }

    public void set_agencia(int _agencia) {
        this._agencia = _agencia;
    }

    public int get_tipo() {
        return _tipo;
    }

    public void set_tipo(int _tipo) {
        this._tipo = _tipo;
    }

    public String get_titular() {
        return _titular;
    }

    public void set_titular(String _titular) {
        this._titular = _titular;
    }

    public int get_saldo() {
        return _saldo;
    }

    public void set_saldo(int _saldo) {
        this._saldo = _saldo;
    }
}
