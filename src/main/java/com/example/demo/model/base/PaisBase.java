package com.example.demo.model.base;

import com.example.demo.model.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class PaisBase implements Base {

    private String nome;
    private String capital;
    private Long populacao;
    private String idiomaOficial;
    private String moeda;
    private String continente;

}
