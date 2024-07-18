package com.aplicacaoException.api.domain.myTask;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class IdDTO {

        @NotNull
        @NotBlank
        @NotEmpty(message = "Id nao pode estar vazio")
        @Size(min = 1, message = "{nome.Size}")
        String id;
}

