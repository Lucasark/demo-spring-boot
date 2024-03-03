package com.example.demo.repository;

import com.example.demo.document.GrandChildEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GrandChildRepository extends MongoRepository<GrandChildEntity, String> {
}
