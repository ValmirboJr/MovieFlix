package org.example.movieflix.service;

import org.example.movieflix.entity.Categoria;
import org.example.movieflix.entity.Streaming;
import org.example.movieflix.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {

    @Autowired
    private StreamingRepository streamingRepository;

    public List<Streaming> BuscarTodas() {
        return streamingRepository.findAll();
    }
    public Streaming salvar(Streaming streaming) {
        return streamingRepository.save(streaming);
    }
    public Optional<Streaming> buscarporid(Long id) {
        return streamingRepository.findById(id);
    }
    public void excluir(Long id) {
        streamingRepository.deleteById(id);
    }
}

