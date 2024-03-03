package com.example.demo.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("survey")
public class SurveyEntity implements Entity {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;

    private String name;

    @DBRef
    private ChildEntity child;

}
