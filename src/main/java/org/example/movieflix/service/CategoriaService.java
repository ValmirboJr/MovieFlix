package org.example.movieflix.service;

import org.example.movieflix.entity.Categoria;
import org.example.movieflix.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> BuscarTodas() {
        return categoriaRepository.findAll();
    }
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    public Optional<Categoria> buscarporid(Long id) {
        return categoriaRepository.findById(id);
    }
    public void excluir(Long id) {
        categoriaRepository.deleteById(id);
    }
}