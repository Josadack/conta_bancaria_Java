package com.conta_bancaria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContaDto(@NotNull(message = "Agência não pode ser nula") int agencia,
                       @NotNull(message = "Tipo não pode ser nulo")  int tipo,
                       @NotBlank(message = "Titular não pode ser vazio") String titular,
                       @NotNull(message = "Agência não pode ser nula") int saldo) {


}
