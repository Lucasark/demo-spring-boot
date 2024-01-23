package com.example.demo.controller;

import com.example.demo.model.request.EstadoQueryRequest;
import com.example.demo.model.request.EstadoRequest;
import com.example.demo.model.response.EstadoResponse;
import com.example.demo.service.EstadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
@RequiredArgsConstructor
public class EstadoController {

    private final EstadoService estadoService;

    @GetMapping("/{estado-id}")
    public ResponseEntity<EstadoResponse> getEstado(
            @PathVariable("estado-id") String estadoId
    ) {
        return ResponseEntity.ok(estadoService.getEstadoById(estadoId));
    }

    @PutMapping("/{estado-id}")
    public ResponseEntity<EstadoResponse> updateEstado(
            @RequestBody EstadoRequest estadoRequest,
            @PathVariable("estado-id") String estadoId
    ) {
        return ResponseEntity.ok(estadoService.updateEstado(estadoRequest, estadoId));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{estado-id}")
    public ResponseEntity<EstadoResponse> deleteEstado(
            @PathVariable("estado-id") String estadoId
    ) {
        estadoService.deleteEstado(estadoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Page<EstadoResponse>> findEstado(
            EstadoQueryRequest estadoQueryRequest,
            @PageableDefault(size = 50) Pageable pageable
    ) {
        return ResponseEntity.ok(estadoService.findEstadosByQuery(estadoQueryRequest, pageable));
    }
}
