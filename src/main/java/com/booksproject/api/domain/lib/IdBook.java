package com.booksproject.api.domain.lib;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record IdBook(
        @NotNull
        @NotBlank
        @NotEmpty
        String id,
        String name,
        String autor
) {

}
