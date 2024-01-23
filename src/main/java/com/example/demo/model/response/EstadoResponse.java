package com.example.demo.model.response;

import com.example.demo.model.Response;
import com.example.demo.model.base.EstadoBase;
import com.example.demo.model.base.PaisBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serial;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class EstadoResponse extends EstadoBase implements Response {

    @Serial
    private static final long serialVersionUID = -1668159447116585271L;

    private String id;
}
