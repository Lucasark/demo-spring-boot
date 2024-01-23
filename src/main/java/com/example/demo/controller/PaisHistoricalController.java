package com.example.demo.controller;

import com.example.demo.model.request.PaisHistoricalRequest;
import com.example.demo.model.response.PaisHistoricalResponse;
import com.example.demo.service.PaisHistoricalService;
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
public class PaisHistoricalController {

    private final PaisHistoricalService paisHistoricalService;

    @GetMapping("/{pais-id}/pais-historicals")
    public ResponseEntity<Page<PaisHistoricalResponse>> getPais(
            @PathVariable("pais-id") String paisId,
            @PageableDefault(size = 50) Pageable pageable
    ) {
        return ResponseEntity.ok(paisHistoricalService.getPaisHistoricalById(paisId, pageable));
    }

    @GetMapping("/{pais-id}/pais-historicals/versions/{version}")
    public ResponseEntity<PaisHistoricalResponse> getPaisByVersion(
            @PathVariable("pais-id") String paisId,
            @PathVariable("version") Long version
    ) {
        return ResponseEntity.ok(paisHistoricalService.getPaisByVersion(paisId, version));
    }

    @PutMapping("/{pais-id}/pais-historicals")
    public ResponseEntity<PaisHistoricalResponse> updatePais(
            @PathVariable("pais-id") String paisId,
            @RequestBody PaisHistoricalRequest paisHistoricalResponse
    ) {
        return ResponseEntity.ok(paisHistoricalService.updateHistoricalPais(paisId, paisHistoricalResponse));
    }

    @PostMapping("/pais-historicals")
    public ResponseEntity<PaisHistoricalResponse> createPais(
            @RequestBody PaisHistoricalRequest paisHistoricalResponse
    ) {
        return ResponseEntity.ok(paisHistoricalService.createPaisHistorical(paisHistoricalResponse));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{pais-id}/pais-historicals")
    public ResponseEntity<Void> deletePais(
            @PathVariable("pais-id") String paisId
    ) {
        paisHistoricalService.deletePais(paisId);
        return ResponseEntity.noContent().build();
    }

}
