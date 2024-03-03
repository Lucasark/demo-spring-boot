package com.example.demo.document;

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
@Document("granchild")
public class GranChildEntity implements Entity {

    @MongoId(targetType = FieldType.STRING)
    private String id;


    private String name;
}
