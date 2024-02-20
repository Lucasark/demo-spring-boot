package com.example.demo.repository;

import com.example.demo.model.response.MongoBugResponse;
import com.example.demo.model.response.MongoBugWorkaroundResponse;
import com.example.demo.repository.document.PaisEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PaisRepositoryCustom extends MongoRepository<PaisEntity, String>, CustomizedPaisRepository {

    Optional<PaisEntity> findByNome(String nome);


    @Aggregation(pipeline = {
            "{$unwind: '$estados'}",
            "{$lookup: {from: 'estado', localField: 'estados.$id', foreignField: '_id', as: 'estadoFF'}}",
            "{$addFields: {estadoMapped: {$map: {input: '$estadoFF' ,as: 'estado',in: {id: {$toString: '$$estado._id'}, h: 'child'}}}}}",
            "{$project: {_id: 0, id: {$toString: '$_id'}, h: 'father' , estado: '$estadoMapped'}}"
    })
    List<MongoBugResponse> getEntity(String id);

    @Aggregation(pipeline = {
            "{$unwind: '$estados'}",
            "{$lookup: {from: 'estado', localField: 'estados.$id', foreignField: '_id', as: 'estadoFF'}}",
            "{$addFields: {estadoMapped: {$map: {input: '$estadoFF' ,as: 'estado',in: {id2: {$toString: '$$estado._id'}, h: 'child'}}}}}",
            "{$project: {_id: 0, id: {$toString: '$_id'}, h: 'father' , estado: '$estadoMapped'}}"
    })
    List<MongoBugWorkaroundResponse> getEntityDiffId(String id);

}
