package org.example.movieflix.controller;

import org.example.movieflix.entity.Categoria;
import org.example.movieflix.mapper.CategoriaMapper;
import org.example.movieflix.request.CategoriaRequest;
import org.example.movieflix.response.CategoriaResponse;
import org.example.movieflix.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping()
    public ResponseEntity<List<CategoriaResponse>> BuscarTodas() {
        return ResponseEntity.ok(categoriaService.BuscarTodas()
                .stream().map(CategoriaMapper::toCategoriaResponse)
                .toList());
    }

    @PostMapping("/salvar")
    public ResponseEntity<CategoriaResponse> salvar(@RequestBody CategoriaRequest categoriaRequest) {
        Categoria savedcategoria = categoriaService.salvar(CategoriaMapper.toCategoria(categoriaRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaMapper.toCategoriaResponse(savedcategoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> buscarPorId(@PathVariable Long id) {
        return categoriaService.buscarporid(id)
                .map(categoria -> ResponseEntity.ok(CategoriaMapper.toCategoriaResponse(categoria)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        categoriaService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}