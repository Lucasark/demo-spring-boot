package com.example.demo.repository.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("estado")
public class EstadoEntity implements Entity {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;
    private String nome;
    private String capital;
    private Long populacao;
    private String sigla;
    private String regiao;

}
