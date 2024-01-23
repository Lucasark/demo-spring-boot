package com.example.demo.repository.impl;

import com.example.demo.model.request.PaisQueryRequest;
import com.example.demo.model.response.PaisResponse;
import com.example.demo.repository.CustomizedPais;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomizedPaisImpl implements CustomizedPais {

    private final MongoTemplate mongoTemplate;

    public Page<PaisResponse> customMethod(PaisQueryRequest paisQueryRequest, Pageable pageable) {
        return null;
    }

}
