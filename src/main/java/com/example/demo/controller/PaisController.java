package com.example.demo.controller;

import com.example.demo.model.dto.PaisPromotionDTO;
import com.example.demo.model.request.EstadoRequest;
import com.example.demo.model.request.PaisQueryRequest;
import com.example.demo.model.response.PaisResponse;
import com.example.demo.service.EstadoService;
import com.example.demo.service.PaisHistoricalService;
import com.example.demo.service.PaisService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
@RequiredArgsConstructor
public class PaisController {

    private final PaisHistoricalService paisHistoricalService;

    private final PaisService paisService;

    private final EstadoService estadoService;

    @GetMapping("/{pais-id}")
    public ResponseEntity<PaisResponse> getPais(
            @PathVariable("pais-id") String paisId
    ) {
        return ResponseEntity.ok(paisService.getPais(paisId));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<PaisResponse>> findPaises(
            PaisQueryRequest paisQueryRequest,
            @PageableDefault(size = 50) Pageable pageable
    ) {
        return ResponseEntity.ok(paisService.searchPais(paisQueryRequest, pageable));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{pais-id}/promote")
    public ResponseEntity<Void> findPaises(
            @PathVariable("pais-id") String searchId
    ) {
        PaisPromotionDTO paisPromotionDTO = paisHistoricalService.getPromotePais(searchId);
        paisService.initPromotion(paisPromotionDTO);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/{pais-id}/estado")
    public ResponseEntity<PaisResponse> createEstadoInPais(
            @RequestBody EstadoRequest estadoRequest,
            @PathVariable("pais-id") String paisId
    ) {
        var paisResponse = paisService.getOptionalPais(paisId);
        if (paisResponse.isPresent()) {
            var estadoResponse = estadoService.createEstado(estadoRequest);
            paisResponse.get().getEstados().add(estadoResponse);
            return ResponseEntity.ok(paisService.savePais(paisResponse.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{pais-id}/estado/{estado-id}")
    public ResponseEntity<PaisResponse> updateEstadoInPais(
            @PathVariable("pais-id") String paisId,
            @PathVariable("estado-id") String estadoId,
            @RequestBody EstadoRequest estadoRequest
    ) {
        var paisResponse = paisService.getOptionalPais(paisId);
        if (paisResponse.isPresent()) {
            var estadoResponse = estadoService.updateEstado(estadoRequest, estadoId);
            paisResponse.get().getEstados().removeIf(e -> e.getId().equals(estadoId));
            paisResponse.get().getEstados().add(estadoResponse);
            return ResponseEntity.ok(paisService.savePais(paisResponse.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{pais-id}/estado/{estado-id}")
    public ResponseEntity<PaisResponse> deleteEstadoInPais(
            @PathVariable("pais-id") String paisId,
            @PathVariable("estado-id") String estadoId
    ) {
        var paisResponse = paisService.getOptionalPais(paisId);
        if (paisResponse.isPresent()) {
            estadoService.deleteEstado(estadoId);
            paisResponse.get().getEstados().removeIf(e -> e.getId().equals(estadoId));
            return ResponseEntity.ok(paisService.savePais(paisResponse.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
