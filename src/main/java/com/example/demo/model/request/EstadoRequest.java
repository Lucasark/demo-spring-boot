package com.example.demo.model.request;

import com.example.demo.model.Request;
import com.example.demo.model.base.EstadoBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serial;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class EstadoRequest extends EstadoBase implements Request {

    @Serial
    private static final long serialVersionUID = 2261390442790476473L;

}
