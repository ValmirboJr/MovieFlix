package org.example.movieflix.request;

import lombok.Builder;

@Builder
public record CategoriaRequest(String nome) {
}