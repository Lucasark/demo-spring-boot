package com.example.demo.controller;

import com.example.demo.model.request.PaisQueryRequest;
import com.example.demo.model.response.PaisResponse;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
@RequiredArgsConstructor
public class EstadoController {

    private final EstadoService estadoService;

    @GetMapping("/{estado-id}")
    public ResponseEntity<PaisResponse> getPais(
            @PathVariable("estado-id") String estadoId
    ) {
        return null;
    }

    @PutMapping("/{estado-id}")
    public ResponseEntity<PaisResponse> updatePais(
            @PathVariable("estado-id") String estadoId
    ) {
        return null;
    }

    @PostMapping
    public ResponseEntity<PaisResponse> createPais() {
        return null;
    }

    @DeleteMapping("/{estado-id}")
    public ResponseEntity<PaisResponse> deletePais(
            @PathVariable("estado-id") String estadoId
    ) {
        return null;
    }

    @GetMapping("/search")
    public ResponseEntity<Page<PaisResponse>> findPaises(
            PaisQueryRequest estadoQueryRequest,
            @PageableDefault(size = 50) Pageable pageable
    ) {
        return null;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{estado-id}/promote")
    public ResponseEntity<Void> findPaises(
            @PathVariable("estado-id") String searchId
    ) {
        return null;
    }
}
