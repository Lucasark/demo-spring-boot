package com.example.demo.service.impl;

import com.example.demo.model.dto.PaisPromotionDTO;
import com.example.demo.model.request.PaisHistoricalRequest;
import com.example.demo.model.response.PaisHistoricalResponse;
import com.example.demo.repository.PaisHistoricalRepository;
import com.example.demo.repository.document.PaisHistoricalEntity;
import com.example.demo.service.PaisHistoricalService;
import com.example.demo.service.PaisService;
import com.example.demo.util.Converter;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaisHistoricalServiceImpl implements PaisHistoricalService {

    private final PaisHistoricalRepository repository;

    private final PaisService paisService;

    private final Converter converter;

    @Override
    public Page<PaisHistoricalResponse> getPaisHistoricalById(String paisId, Pageable pageable) {
        var found = repository.findByPkId(new ObjectId(paisId), pageable);
        var content = found.getContent().stream().map(converter::toPaisHistoricalResponse).toList();
        return new PageImpl<>(content, found.getPageable(), found.getTotalElements());
    }

    @Override
    public PaisHistoricalResponse updateHistoricalPais(String paisId, PaisHistoricalRequest paisHistoricalRequest) {

        rulePromotedPais(paisId);

        var entity = repository.findFirst1ByPkIdOrderByPkVersionDesc(new ObjectId(paisId))
                .orElseThrow(() -> new RuntimeException("Pais não encontrado!"));

        entity = converter.toPaisHistoricalEntity(entity, paisHistoricalRequest);

        entity.getPk().setVersion(entity.getPk().getVersion() + 1);

        entity = repository.save(entity);

        return converter.toPaisHistoricalResponse(entity);

    }

    @Override
    public PaisHistoricalResponse createPaisHistorical(PaisHistoricalRequest paisHistoricalRequest) {

        rulePromotedPaisByName(paisHistoricalRequest.getNome());

        var entity = converter.convert(paisHistoricalRequest, PaisHistoricalEntity.class);

        return converter.toPaisHistoricalResponse(repository.save(entity));
    }

    @Override
    public void deletePais(String paisId) {
        repository.deleteByPkId(new ObjectId(paisId));
    }

    private void rulePromotedPais(String paisId) {
        var pais = paisService.getOptionalPais(paisId);

        if (pais.isPresent()) {
            throw new RuntimeException("Pais já promovido!");
        }
    }

    @Override
    public PaisPromotionDTO getPromotePais(String paisId) {

        rulePromotedPais(paisId);

        var paisHistorical = repository.findFirst1ByPkIdOrderByPkVersionDesc(new ObjectId(paisId))
                .orElseThrow(() -> new RuntimeException("Pais não encontrado!"));

        return converter.paisPromotionDTO(paisHistorical);
    }

    @Override
    public PaisHistoricalResponse getPaisByVersion(String paisId, Long version) {
        var entity = repository.findByPkIdAndPkVersion(new ObjectId(paisId), version)
                .orElseThrow(() -> new RuntimeException("Pais não encontrado!"));

        return converter.toPaisHistoricalResponse(entity);
    }

    private void rulePromotedPaisByName(String nomePais) {
        var pais = paisService.getOptionalPaisByName(nomePais);

        if (pais.isPresent()) {
            throw new RuntimeException("Pais já promovido!");
        }
    }
}
