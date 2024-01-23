package com.example.demo.service;

import com.example.demo.model.dto.PaisPromotionDTO;
import com.example.demo.model.request.PaisQueryRequest;
import com.example.demo.model.response.PaisResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PaisService {

    PaisResponse getPais(String paisId);

    Optional<PaisResponse> getOptionalPais(String paisId);

    Optional<PaisResponse> getOptionalPaisByName(String paisId);

    void initPromotion(PaisPromotionDTO paisPromotionDTO);

    Page<PaisResponse> searchPais(PaisQueryRequest paisQueryRequest, Pageable pageable);

    PaisResponse savePais(PaisResponse paisResponse);
}
