package com.booksproject.api.domain.lib;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RequestLib(
        @NotNull
        @NotBlank
        @NotEmpty
        String name,
        @NotNull
        @NotBlank
        @NotEmpty
        String autor) {

}

