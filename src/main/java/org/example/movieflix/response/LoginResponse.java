package org.example.movieflix.response;

import lombok.Builder;

@Builder
public record LoginResponse(String token) {
}
