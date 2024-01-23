package com.example.demo.repository.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("pais_hist")
@CompoundIndex(name = "pais_hist_idx", def = "{'nome': 1, 'pk.id': 1, 'pk.version': 1}", unique = true)
public class PaisHistoricalEntity implements Entity {

    @Id
    @Builder.Default
    private PaisHistoricalPK pk = PaisHistoricalPK.builder().build();
    private String nome;
    private String capital;
    private Long populacao;
    private String idiomaOficial;
    private String moeda;
    private String continente;
}
