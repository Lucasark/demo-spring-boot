package com.example.demo.repository.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("pais")
public class PaisEntity implements Entity {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
    @Indexed(unique = true)
    private String nome;
    private String capital;
    private Long populacao;
    private String idiomaOficial;
    private String moeda;
    private String continente;

    @DBRef
    @Builder.Default
    private Set<EstadoEntity> estados = new HashSet<>();

}
