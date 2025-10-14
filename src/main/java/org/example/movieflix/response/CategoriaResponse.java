package org.example.movieflix.response;

import lombok.Builder;

@Builder
public record CategoriaResponse(Long id, String nome) {
}