package org.example.movieflix.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.movieflix.entity.Filmes;
import org.example.movieflix.mapper.FilmesMapper;
import org.example.movieflix.request.FilmesRequest;
import org.example.movieflix.response.FilmesResponse;
import org.example.movieflix.service.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
@Tag(name = "Filmes", description = "Recurso responsavel pelo gerenciamento dos filmes")
public class FilmesController {

    @Autowired
    private FilmesService filmesService;

    @Operation(summary = "Salvar Filme", description = "Metodo responsavel por salvar um novo filme")
    @ApiResponse(responseCode = "201", description = "Filme salvo com sucesso",
    content = @Content(schema = @Schema(implementation = FilmesResponse.class)))

    @PostMapping("/salvar")
    public ResponseEntity<FilmesResponse> salvar(@Valid @RequestBody FilmesRequest filmesRequest) {
        Filmes salvo = filmesService.salvar(FilmesMapper.toFilmes(filmesRequest));
        return ResponseEntity.ok(FilmesMapper.toFilmesResponse(salvo));
    }

    @GetMapping
    public ResponseEntity<List<FilmesResponse>> listar() {
        return ResponseEntity.ok(filmesService.buscarTodos().stream().map(FilmesMapper::toFilmesResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmesResponse> buscarporid(@PathVariable Long id) {
     return filmesService.buscarFilmesporid(id)
                .map(filme ->  ResponseEntity.ok(FilmesMapper.toFilmesResponse(filme)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmesResponse> atualizar(@PathVariable Long id, @Valid @RequestBody FilmesRequest filmesRequest) {
        return filmesService.atualizar(id,FilmesMapper.toFilmes(filmesRequest))
                .map(filmes -> ResponseEntity.ok(FilmesMapper.toFilmesResponse(filmes)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/busca")
    public ResponseEntity<List<FilmesResponse>> buscarporcateoria(@RequestParam Long categoria) {
        return ResponseEntity.ok(filmesService.buscarFilmesPorCategoria(categoria).stream().map(FilmesMapper::toFilmesResponse).toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Filmes> optionalFilmes = filmesService.buscarFilmesporid(id);
        if (optionalFilmes.isPresent()) {
            filmesService.deletarfilme(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
