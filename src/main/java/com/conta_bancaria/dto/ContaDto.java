package com.conta_bancaria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContaDto(@NotNull(message = "Tipo não pode ser nulo")  int agencia,
                       @NotNull(message = "Tipo não pode ser nulo")  int numero,
                       @NotBlank(message = "Titular não pode ser vazio") String titular,
                       @NotNull(message = "Saldo não pode ser nula") int saldo,
                       @NotNull(message = "Limite não pode ser nula") double limite,
                       @NotNull(message = "Aniversario não pode ser nula") int aniversario)

                       {



}
