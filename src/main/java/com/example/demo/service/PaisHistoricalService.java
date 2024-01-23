package com.example.demo.service;

import com.example.demo.model.dto.PaisPromotionDTO;
import com.example.demo.model.request.PaisHistoricalRequest;
import com.example.demo.model.response.PaisHistoricalResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaisHistoricalService {

    Page<PaisHistoricalResponse> getPaisHistoricalById(String paisId, Pageable pageable);

    PaisHistoricalResponse updateHistoricalPais(String paisId, PaisHistoricalRequest paisHistoricalRequest);

    PaisHistoricalResponse createPaisHistorical(PaisHistoricalRequest paisHistoricalRequest);

    void deletePais(String paisId);

    PaisPromotionDTO getPromotePais(String paisId);

    PaisHistoricalResponse getPaisByVersion(String paisId, Long version);
}
