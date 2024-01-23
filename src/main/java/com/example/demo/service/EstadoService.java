package com.example.demo.service;

import com.example.demo.model.request.EstadoQueryRequest;
import com.example.demo.model.request.EstadoRequest;
import com.example.demo.model.response.EstadoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EstadoService {

    EstadoResponse getEstadoById(String id);

    EstadoResponse updateEstado(EstadoRequest estadoRequest, String id);

    void deleteEstado(String id);

    Page<EstadoResponse> findEstadosByQuery(EstadoQueryRequest estadoQueryRequest, Pageable pageable);

    EstadoResponse createEstado(EstadoRequest estadoRequest);
}
