package com.example.demo;

import com.example.demo.repository.EstadoRepository;
import com.example.demo.repository.PaisRepository;
import com.example.demo.repository.document.EstadoEntity;
import com.example.demo.repository.document.PaisEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @BeforeEach
    void cleanUp() {
        paisRepository.deleteAll();
        estadoRepository.deleteAll();
    }

    @Test
    void normal_willFail() {

        var e1 = estadoRepository.save(EstadoEntity.builder().build());

        var p = paisRepository.save(PaisEntity.builder()
                .estados(Set.of(e1))
                .build());

        var response = paisRepository.getEntityNormal(p.getId());

        var id = response.get(0).getEstado().iterator().next().getId();

        assertThat(id).isNotNull();
    }

    @Test
    void diffIdname_willWork() {

        var e1 = estadoRepository.save(EstadoEntity.builder().build());

        var p = paisRepository.save(PaisEntity.builder()
                .estados(Set.of(e1))
                .build());

        var response = paisRepository.getEntityUsingId2(p.getId());

        var id = response.get(0).getEstado().iterator().next().getId2();

        assertThat(id).isNotNull();
    }

    @Test
    void withoutValue_willFail() {

        var e1 = estadoRepository.save(EstadoEntity.builder().build());

        var p = paisRepository.save(PaisEntity.builder()
                .estados(Set.of(e1))
                .build());

        var response = paisRepository.getEntityWithFieldWithoutValue(p.getId());

        var id = response.get(0).getEstado().iterator().next().getId();

        assertThat(id).isNotNull();
    }

    @Test
    void withValue_willWork() {

        var e1 = estadoRepository.save(EstadoEntity.builder().build());

        var p = paisRepository.save(PaisEntity.builder()
                .estados(Set.of(e1))
                .build());

        var response = paisRepository.getEntityWithFieldAndValue(p.getId());

        var id = response.get(0).getEstado().iterator().next().getId();

        assertThat(id).isNotNull();
    }

}
