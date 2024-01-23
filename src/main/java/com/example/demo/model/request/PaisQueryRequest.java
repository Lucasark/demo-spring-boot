package com.example.demo.model.request;

import com.example.demo.model.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaisQueryRequest implements Request {

    @Serial
    private static final long serialVersionUID = -7249286781746058800L;

    private String capital;

    private String continente;

    private String moeda;
}
