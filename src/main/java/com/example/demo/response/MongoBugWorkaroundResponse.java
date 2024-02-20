package com.example.demo.response;

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
public class MongoBugWorkaroundResponse {

    private String id;

    private String h;

    @Builder.Default
    private Set<MongoBugWorkaroundChildResponse> estado = new HashSet<>();

}
