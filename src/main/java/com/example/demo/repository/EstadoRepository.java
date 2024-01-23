package com.example.demo.repository;

import com.example.demo.repository.document.EstadoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends MongoRepository<EstadoEntity, String> {
}
