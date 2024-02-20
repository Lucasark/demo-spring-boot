package com.example.demo.response.fieldandvalue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MongoBugWithFieldAndValueChildResponse {

    @Field("id")
    private String id;

    private String h;

}
