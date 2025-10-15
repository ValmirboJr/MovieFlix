package org.example.movieflix.mapper;

import lombok.experimental.UtilityClass;
import org.example.movieflix.entity.Categoria;
import org.example.movieflix.entity.Filmes;
import org.example.movieflix.entity.Streaming;
import org.example.movieflix.request.FilmesRequest;
import org.example.movieflix.response.CategoriaResponse;
import org.example.movieflix.response.FilmesResponse;
import org.example.movieflix.response.StreamingResponse;

import java.util.List;

@UtilityClass
public class FilmesMapper {

    public static Filmes toFilmes(FilmesRequest filmesRequest) {

      List<Categoria> categorias = filmesRequest.categoria().stream()
                .map(categoriaid-> Categoria.builder().id(categoriaid).build())
                .toList();

        List<Streaming> streamings = filmesRequest.categoria().stream()
                .map(streamingid-> Streaming.builder().id(streamingid).build())
                .toList();


        return Filmes.builder()
                .titulo(filmesRequest.titulo())
                .descricao(filmesRequest.descricao())
                .dataLancamento(filmesRequest.dataLancamento())
                .avaliacao(filmesRequest.avaliacao())
                .categorias(categorias)
                .streamings(streamings)
                      .build();
    }

    public static FilmesResponse toFilmesResponse(Filmes filmes) {

        List<CategoriaResponse> categorias = filmes.getCategorias()
                .stream()
                .map(categoria -> CategoriaMapper.toCategoriaResponse(categoria))
                .toList();

        List<StreamingResponse> streamings = filmes.getStreamings()
                .stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming))
                .toList();


        return FilmesResponse.builder()
                .id(filmes.getId())
                .titulo(filmes.getTitulo())
                .descricao(filmes.getDescricao())
                .datalancamento(filmes.getDataLancamento())
                .avaliacao(filmes.getAvaliacao())
                .categoria(categorias)
                .streamings(streamings)
                .build();
    }
}
