package com.example.demo.repository;

import com.example.demo.document.GranChildEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GrandChildRepository extends MongoRepository<GranChildEntity, String> {
}
