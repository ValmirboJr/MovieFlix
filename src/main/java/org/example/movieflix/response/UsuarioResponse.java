package org.example.movieflix.response;

import lombok.Builder;

@Builder
public record UsuarioResponse(Long id, String nome, String email) {
}
