package com.example.demo.repository;

import com.example.demo.repository.document.PaisEntity;
import com.example.demo.response.id2.MongoBugId2Response;
import com.example.demo.response.normal.MongoBugResponse;
import com.example.demo.response.fieldandvalue.MongoBugWithFieldAndValueResponse;
import com.example.demo.response.onlyfield.MongoBugWithFieldWithoutValueResponse;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PaisRepository extends MongoRepository<PaisEntity, String> {

    @Aggregation(pipeline = {
            "{$unwind: '$estados'}",
            "{$lookup: {from: 'estado', localField: 'estados.$id', foreignField: '_id', as: 'estadoFF'}}",
            "{$addFields: {estadoMapped: {$map: {input: '$estadoFF' ,as: 'estado',in: {id: {$toString: '$$estado._id'}, h: 'child'}}}}}",
            "{$project: {_id: 0, id: {$toString: '$_id'}, h: 'father' , estado: '$estadoMapped'}}"
    })
    List<MongoBugResponse> getEntityNormal(String id);

    @Aggregation(pipeline = {
            "{$unwind: '$estados'}",
            "{$lookup: {from: 'estado', localField: 'estados.$id', foreignField: '_id', as: 'estadoFF'}}",
            "{$addFields: {estadoMapped: {$map: {input: '$estadoFF' ,as: 'estado',in: {id: {$toString: '$$estado._id'}, h: 'child'}}}}}",
            "{$project: {_id: 0, id: {$toString: '$_id'}, h: 'father' , estado: '$estadoMapped'}}"
    })
    List<MongoBugWithFieldWithoutValueResponse> getEntityWithFieldWithoutValue(String id);

    @Aggregation(pipeline = {
            "{$unwind: '$estados'}",
            "{$lookup: {from: 'estado', localField: 'estados.$id', foreignField: '_id', as: 'estadoFF'}}",
            "{$addFields: {estadoMapped: {$map: {input: '$estadoFF' ,as: 'estado',in: {id: {$toString: '$$estado._id'}, h: 'child'}}}}}",
            "{$project: {_id: 0, id: {$toString: '$_id'}, h: 'father' , estado: '$estadoMapped'}}"
    })
    List<MongoBugWithFieldAndValueResponse> getEntityWithFieldAndValue(String id);

    @Aggregation(pipeline = {
            "{$unwind: '$estados'}",
            "{$lookup: {from: 'estado', localField: 'estados.$id', foreignField: '_id', as: 'estadoFF'}}",
            "{$addFields: {estadoMapped: {$map: {input: '$estadoFF' ,as: 'estado',in: {id2: {$toString: '$$estado._id'}, h: 'child'}}}}}",
            "{$project: {_id: 0, id: {$toString: '$_id'}, h: 'father' , estado: '$estadoMapped'}}"
    })
    List<MongoBugId2Response> getEntityUsingId2(String id);

}
