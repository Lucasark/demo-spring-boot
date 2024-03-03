package com.example.demo.repository;

import com.example.demo.document.SurveyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SurveyRepository extends MongoRepository<SurveyEntity, String> {

    Optional<SurveyEntity> findByIdAndChildGranChildId(String id, String grandChildId);
}
