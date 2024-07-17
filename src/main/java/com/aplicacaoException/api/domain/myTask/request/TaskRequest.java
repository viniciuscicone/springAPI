package com.aplicacaoException.api.domain.myTask.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class TaskRequest {

    @Valid
    @NotNull
    @NotBlank
    @NotEmpty(message = "Campo invalido")
    @Size(min = 0, message = "{nome.Size}")
    private String task;
    @Valid
    @NotNull
    @NotBlank
    @NotEmpty(message = "Campo invalido")
    @Size(min = 0, message = "{nome.Size}")
    private String autor;


}
