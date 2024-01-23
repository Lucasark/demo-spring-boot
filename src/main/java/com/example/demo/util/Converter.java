package com.example.demo.util;

import com.example.demo.model.dto.PaisPromotionDTO;
import com.example.demo.model.request.PaisHistoricalRequest;
import com.example.demo.model.response.PaisHistoricalResponse;
import com.example.demo.repository.document.PaisHistoricalEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Converter {

    private final ModelMapper modalMapper;

    public <T> T convert(Object source, Class<T> targetClass) {
        return modalMapper.map(source, targetClass);
    }

    public PaisHistoricalEntity toPaisHistoricalEntity(PaisHistoricalEntity paisHistoricalEntity, PaisHistoricalRequest paisHistoricalRequest) {
        var mapped = modalMapper.map(paisHistoricalRequest, PaisHistoricalEntity.class);
        mapped.getPk().setId(paisHistoricalEntity.getPk().getId());
        mapped.getPk().setVersion(paisHistoricalEntity.getPk().getVersion());
        return mapped;
    }

    public PaisHistoricalResponse toPaisHistoricalResponse(PaisHistoricalEntity paisHistoricalEntity) {
        var mapped = modalMapper.map(paisHistoricalEntity, PaisHistoricalResponse.class);
        mapped.setId(paisHistoricalEntity.getPk().getId().toString());
        mapped.setVersion(paisHistoricalEntity.getPk().getVersion());
        return mapped;
    }

    public PaisPromotionDTO paisPromotionDTO(PaisHistoricalEntity paisHistoricalEntity) {
        var mapped = modalMapper.map(paisHistoricalEntity, PaisPromotionDTO.class);
        mapped.setId(paisHistoricalEntity.getPk().getId().toString());
        return mapped;
    }

}
