package com.example.demo.response.id2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MongoBugId2Response {

    private String id;

    private String h;

    @Builder.Default
    private Set<MongoBugId2ChildResponse> estado = new HashSet<>();

}
