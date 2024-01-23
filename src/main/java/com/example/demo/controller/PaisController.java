package com.example.demo.controller;

import com.example.demo.model.dto.PaisPromotionDTO;
import com.example.demo.model.request.PaisQueryRequest;
import com.example.demo.model.response.PaisResponse;
import com.example.demo.service.PaisHistoricalService;
import com.example.demo.service.PaisService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * CRUD - Não tem DELETE porque o Pais promovido não pode ser deletado
 * CRUD - Não tem POST porque o Pais apenas é criado por promoção
 */
@RestController
@RequestMapping("/pais")
@RequiredArgsConstructor
public class PaisController {

    private final PaisHistoricalService paisHistoricalService;

    private final PaisService paisService;

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
}
