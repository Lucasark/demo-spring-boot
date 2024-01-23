package com.example.demo.repository;

import com.example.demo.repository.document.PaisHistoricalEntity;
import com.example.demo.repository.document.PaisHistoricalPK;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaisHistoricalRepository extends MongoRepository<PaisHistoricalEntity, PaisHistoricalPK> {

    Page<PaisHistoricalEntity> findByPkId(ObjectId id, Pageable pageable);

    Optional<PaisHistoricalEntity> findFirst1ByPkIdOrderByPkVersionDesc(ObjectId id);

    void deleteByPkId(ObjectId id);
}
