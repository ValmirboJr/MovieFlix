package org.example.movieflix.controller;

import org.example.movieflix.entity.Categoria;
import org.example.movieflix.entity.Streaming;
import org.example.movieflix.mapper.CategoriaMapper;
import org.example.movieflix.mapper.StreamingMapper;
import org.example.movieflix.request.CategoriaRequest;
import org.example.movieflix.request.StreamingRequest;
import org.example.movieflix.response.CategoriaResponse;
import org.example.movieflix.response.StreamingResponse;
import org.example.movieflix.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streaming")
public class StreamingController {

    @Autowired
    private StreamingService streamingService;

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> BuscarTodas() {
        return ResponseEntity.ok(streamingService.BuscarTodas()
                .stream().map(StreamingMapper::toStreamingResponse)
                .toList());
    }

    @PostMapping("/salvar")
    public ResponseEntity<StreamingResponse> salvar(@RequestBody StreamingRequest streamingRequest) {
        Streaming saveStreaming = streamingService.salvar(StreamingMapper.toStreaming(streamingRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(saveStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> buscarPorId(@PathVariable Long id) {
        return streamingService.buscarporid(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarStreaming(@PathVariable Long id) {
        streamingService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
