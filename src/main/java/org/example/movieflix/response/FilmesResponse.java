package org.example.movieflix.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record FilmesResponse(@Schema(type = "long",description = "Codigo do filme") Long id,
                             @Schema(type = "string", description = "nome do filme")
                             String titulo,
                             String descricao,
                             @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
                             LocalDate datalancamento,
                             double avaliacao,
                             List<CategoriaResponse> categoria,
                             List<StreamingResponse> streamings) {
}
