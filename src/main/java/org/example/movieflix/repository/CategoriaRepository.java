package org.example.movieflix.repository;

import jdk.jfr.Registered;
import org.example.movieflix.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}