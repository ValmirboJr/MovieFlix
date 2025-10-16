package org.example.movieflix.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long id, String nome, String email) {
}
