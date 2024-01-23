package com.example.demo.repository;

import com.example.demo.repository.document.PaisEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PaisRepositoryCustom extends MongoRepository<PaisEntity, String>, CustomizedPais {

    Optional<PaisEntity> findByNome(String nome);

}
