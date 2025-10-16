package org.example.movieflix.request;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDate;
import java.util.List;

public record FilmesRequest(String titulo,
                            String descricao,
                            @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
                            LocalDate dataLancamento,
                            double avaliacao,
                            List<Long> categoria,
                            List<Long> streaming) {
}
