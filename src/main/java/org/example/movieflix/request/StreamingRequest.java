package org.example.movieflix.request;

import lombok.Builder;

@Builder
public record StreamingRequest(String nome) {
}
