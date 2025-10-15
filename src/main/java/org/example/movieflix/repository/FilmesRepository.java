package org.example.movieflix.repository;


import org.example.movieflix.entity.Categoria;
import org.example.movieflix.entity.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmesRepository extends JpaRepository<Filmes,Long> {

    List<Filmes> findByCategorias(List<Categoria> categorias);
}
