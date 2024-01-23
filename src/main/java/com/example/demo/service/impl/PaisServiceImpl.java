package com.example.demo.service.impl;

import com.example.demo.model.dto.PaisPromotionDTO;
import com.example.demo.model.request.PaisQueryRequest;
import com.example.demo.model.response.PaisResponse;
import com.example.demo.repository.PaisRepositoryCustom;
import com.example.demo.repository.document.PaisEntity;
import com.example.demo.service.PaisService;
import com.example.demo.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaisServiceImpl implements PaisService {

    private final PaisRepositoryCustom repository;

    private final Converter converter;

    @Override
    public PaisResponse getPais(String paisId) {
        var entity = repository.findById(paisId).orElseThrow(() -> new RuntimeException("Pais not found"));
        return converter.convert(entity, PaisResponse.class);
    }

    @Override
    public Optional<PaisResponse> getOptionalPais(String paisId) {
        return repository.findById(paisId).map(paisEntity -> converter.convert(paisEntity, PaisResponse.class));
    }

    @Override
    public Optional<PaisResponse> getOptionalPaisByName(String nome) {
        return repository.findByNome(nome).map(paisEntity -> converter.convert(paisEntity, PaisResponse.class));
    }

    @Override
    public void initPromotion(PaisPromotionDTO paisPromotionDTO) {
        var entity = converter.convert(paisPromotionDTO, PaisEntity.class);
        repository.save(entity);
    }

    @Override
    public Page<PaisResponse> searchPais(PaisQueryRequest paisQueryRequest, Pageable pageable) {
        return repository.customMethod(paisQueryRequest, pageable);
    }

}
