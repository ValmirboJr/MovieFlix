package org.example.movieflix.mapper;

import lombok.experimental.UtilityClass;
import org.example.movieflix.entity.Categoria;
import org.example.movieflix.request.CategoriaRequest;
import org.example.movieflix.response.CategoriaResponse;

@UtilityClass
public class CategoriaMapper {

    public static Categoria toCategoria(CategoriaRequest categoriaRequest) {
        return Categoria
                .builder()
                .nome(categoriaRequest.nome())
                .build();
    }

    public static CategoriaResponse toCategoriaResponse(Categoria categoria) {
        return CategoriaResponse
                .builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .build();
    }
}