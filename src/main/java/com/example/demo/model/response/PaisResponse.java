package com.example.demo.model.response;

import com.example.demo.model.Response;
import com.example.demo.model.base.PaisBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PaisResponse extends PaisBase implements Response {

    @Serial
    private static final long serialVersionUID = -1668159447116585271L;

    private String id;

    @Builder.Default
    private Set<EstadoResponse> estados = new HashSet<>();
}
