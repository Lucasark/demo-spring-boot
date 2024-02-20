package com.example.demo.repository;

import com.example.demo.repository.document.EstadoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstadoRepository extends MongoRepository<EstadoEntity, String> {

}
