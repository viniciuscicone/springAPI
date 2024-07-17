package com.aplicacaoException.api.domain.myTask;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record idDTO(

        @NotNull
        @NotBlank
        @NotEmpty(message = "Id nao pode estar vazio")
        @Size(min = 1, message = "{nome.Size}")
        String id

) {
}
