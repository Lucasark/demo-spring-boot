package com.example.demo.response.onlyfield;

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
public class MongoBugWithFieldWithoutValueResponse {

    private String id;

    private String h;

    @Builder.Default
    private Set<MongoBugWithFieldWithoutValueChildResponse> estado = new HashSet<>();

}