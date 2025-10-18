package org.example.movieflix.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;


import java.time.LocalDate;
import java.util.List;

public record FilmesRequest(@Schema(type = "string", description = "nome do filme")
                            @NotEmpty(message = "Titulo é obrigatorio.") String titulo,
                            String descricao,
                            @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
                            @Schema(type = "date", description = "Data de lançamento. ex:01/10/2002")
                            LocalDate dataLancamento,
                            @Schema(type = "double", description = "Avaliação. ex:2.8")
                            double avaliacao,
                            @Schema(type = "array",description = "Lista de codigo de categoria")
                            List<Long> categoria,
                            @Schema(type = "array",description = "Lista de codigo de streaming")
                            List<Long> streaming) {
}
