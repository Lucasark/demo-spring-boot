package com.example.demo.repository;

import com.example.demo.model.request.PaisQueryRequest;
import com.example.demo.model.response.PaisResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomizedPaisRepository {
    Page<PaisResponse> findByCriteria(PaisQueryRequest paisQueryRequest, Pageable pageable);
}
