package com.aplicacaoException.api.domain.myTask;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class TaskDTO {

        @NotNull
        @NotBlank
        @NotEmpty(message = "{nome.NotEmpty} task")
        @Size(min = 1, message = "{nome.Size}")
        @Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$",message = "Permitido apenas String")
        String task;
        @Valid
        @NotNull
        @NotBlank
        @NotEmpty(message = "{nome.NotEmpty} autor")
        @Size(min = 1, message = "{nome.Size}")
        @Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$",message = "Permitido apenas String")
        String autor;

}
