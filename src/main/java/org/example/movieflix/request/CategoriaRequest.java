package org.example.movieflix.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record CategoriaRequest(@NotEmpty(message = "Nome da Categoria obrigatorio.") String nome) {
}