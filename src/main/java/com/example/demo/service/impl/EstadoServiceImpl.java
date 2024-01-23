package com.example.demo.service.impl;

import com.example.demo.model.request.EstadoQueryRequest;
import com.example.demo.model.request.EstadoRequest;
import com.example.demo.model.response.EstadoResponse;
import com.example.demo.repository.EstadoRepository;
import com.example.demo.repository.document.EstadoEntity;
import com.example.demo.service.EstadoService;
import com.example.demo.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstadoServiceImpl implements EstadoService {

    private final EstadoRepository repository;

    private final Converter converter;

    @Override
    public EstadoResponse getEstadoById(String id) {
        var estado = repository.findById(id).orElseThrow(() -> new RuntimeException("Estado não encontrado"));
        return converter.convert(estado, EstadoResponse.class);
    }

    @Override
    public EstadoResponse updateEstado(EstadoRequest estadoResponse, String id) {
        var estado = repository.findById(id).orElseThrow(() -> new RuntimeException("Estado não encontrado"));

        var entity = converter.convert(estadoResponse, EstadoEntity.class);
        entity.setId(estado.getId());

        entity = repository.save(entity);

        return converter.convert(entity, EstadoResponse.class);
    }

    @Override
    public void deleteEstado(String id) {
        repository.deleteById(id);
    }

    @Override
    public Page<EstadoResponse> findEstadosByQuery(EstadoQueryRequest estadoQueryRequest, Pageable pageable) {
        return null;
    }
}
