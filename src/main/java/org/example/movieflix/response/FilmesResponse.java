package org.example.movieflix.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record FilmesResponse(Long id,
                             String titulo,
                             String descricao,
                             @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
                             LocalDate datalancamento,
                             double avaliacao,
                             List<CategoriaResponse> categoria,
                             List<StreamingResponse> streamings) {



}
