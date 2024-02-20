package com.example.demo.response.onlyfield;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MongoBugWithFieldWithoutValueChildResponse {

    @Field
    private String id;

    private String h;

}
