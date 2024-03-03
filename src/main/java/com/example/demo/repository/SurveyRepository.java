package com.example.demo.repository;

import com.example.demo.document.SurveyEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SurveyRepository extends MongoRepository<SurveyEntity, String> {

    Optional<SurveyEntity> findByChildGrandChildId(String grandChildId);

    Optional<SurveyEntity> findByIdAndChildGrandChildId(String id, String grandChildId);

    Optional<SurveyEntity> findByChildId(String childId);

    @Aggregation(pipeline = {
            "{$lookup: { from: 'child', localField: 'child.$id', foreignField: '_id', as: 'child' }}",
            "{$unwind: '$child'}",
            "{$addFields: { grandchild: '$child.grandChild' }}",
            "{$lookup: { from: 'grandchild', localField: 'grandchild.$id', foreignField: '_id', as: 'grandchild' }}",
            "{$unwind: '$grandchild'}",
            "{$match: { 'grandchild._id': ?0 }}"
    })
    Optional<SurveyEntity> findByAggregation(String grandChildId);
}
