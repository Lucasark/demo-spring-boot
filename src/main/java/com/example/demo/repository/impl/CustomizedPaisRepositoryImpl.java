package com.example.demo.repository.impl;

import com.example.demo.model.request.PaisQueryRequest;
import com.example.demo.model.response.PaisResponse;
import com.example.demo.repository.CustomizedPaisRepository;
import com.example.demo.repository.document.PaisEntity;
import com.example.demo.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Objects.nonNull;

@Component
@RequiredArgsConstructor
public class CustomizedPaisRepositoryImpl implements CustomizedPaisRepository {

    private final MongoTemplate mongoTemplate;

    private final Converter converter;

    public Page<PaisResponse> findByCriteria(PaisQueryRequest paisQueryRequest, Pageable pageable) {

        Query query = new Query().with(pageable);

        if (nonNull(paisQueryRequest.getCapital()))
            query.addCriteria(Criteria.where("capital").is(paisQueryRequest.getCapital()));
        if (nonNull(paisQueryRequest.getContinente()))
            query.addCriteria(Criteria.where("continente").is(paisQueryRequest.getContinente()));
        if (nonNull(paisQueryRequest.getMoeda()))
            query.addCriteria(Criteria.where("moeda").is(paisQueryRequest.getMoeda()));

        List<PaisEntity> founds = mongoTemplate.find(query, PaisEntity.class);

        if (founds.isEmpty()) throw new RuntimeException("Não achou nada!");

        var responses = founds.stream().map(v -> converter.convert(v, PaisResponse.class)).toList();

        var count = mongoTemplate.count(query, PaisEntity.class);

        return new PageImpl<>(responses, pageable, count);
    }

}
