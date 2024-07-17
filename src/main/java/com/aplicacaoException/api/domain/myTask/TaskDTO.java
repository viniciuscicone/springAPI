package com.aplicacaoException.api.domain.myTask;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record TaskDTO (

        @NotNull
        @NotBlank
        @NotEmpty(message = "{nome.NotEmpty}")
        @Size(min = 1, message = "{nome.Size}")
        String task,
        @Valid
        @NotNull
        @NotBlank
        @NotEmpty(message = "{nome.NotEmpty}")
        @Size(min = 1, message = "{nome.Size}")
        String autor

) {

}
