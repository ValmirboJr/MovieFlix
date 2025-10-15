package org.example.movieflix.service;

import org.example.movieflix.entity.Categoria;
import org.example.movieflix.entity.Filmes;
import org.example.movieflix.entity.Streaming;
import org.example.movieflix.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmesService {

    @Autowired
    private FilmesRepository filmesRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private StreamingService streamingService;

    public Filmes salvar(Filmes filmes) {
        filmes.setCategorias(buscarCategorias(filmes.getCategorias()));
        filmes.setStreamings(buscarStreaming(filmes.getStreamings()));
        return filmesRepository.save(filmes);
    }

    public List<Filmes> buscarTodos() {
        return filmesRepository.findAll();
    }

    private List<Categoria> buscarCategorias(List<Categoria> categorias) {
        List<Categoria> categoriaencontrada = new ArrayList<>();
        categorias.forEach(categoria -> {
            categoriaService.buscarporid(categoria.getId()).ifPresent(categoriaencontrada::add);
        });
        return categoriaencontrada;
    }

    private List<Streaming> buscarStreaming(List<Streaming> streamings) {
        List<Streaming> streamingsencontrados = new ArrayList<>();
        streamings.forEach(categoria -> {
            streamingService.buscarporid(categoria.getId()).ifPresent(streamingsencontrados::add);
        });
        return streamingsencontrados;
    }
    public Optional<Filmes> buscarFilmesporid(Long id) {
        return filmesRepository.findById(id);
    }
    public Optional<Filmes> atualizar(Long filmeid, Filmes filmesAtualizado) {
        Optional<Filmes> optFilmes = filmesRepository.findById(filmeid);
        if (optFilmes.isPresent()) {
            List<Categoria> categorias = this.buscarCategorias(filmesAtualizado.getCategorias());
            List<Streaming> streamings = this.buscarStreaming(filmesAtualizado.getStreamings());

            Filmes filmes = optFilmes.get();
           filmes.setTitulo(filmesAtualizado.getTitulo());
           filmes.setDescricao(filmesAtualizado.getDescricao());
           filmes.setDataLancamento(filmesAtualizado.getDataLancamento());
           filmes.setAvaliacao(filmesAtualizado.getAvaliacao());
           filmes.getCategorias().clear();
           filmes.getCategorias().addAll(categorias);
           filmes.getStreamings().clear();
           filmes.getStreamings().addAll(streamings);

           filmesRepository.save(filmes);
           return Optional.of(filmes);
        }
        return Optional.empty();
    }

    public List<Filmes> buscarFilmesPorCategoria(Long categoriaid) {
        return filmesRepository.findByCategorias(List.of(Categoria.builder().id(categoriaid).build()));
    }

    public void deletarfilme(Long filmeid) {
        filmesRepository.deleteById(filmeid);
    }
}
