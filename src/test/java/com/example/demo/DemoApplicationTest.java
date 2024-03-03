package com.example.demo;

import com.example.demo.document.ChildEntity;
import com.example.demo.document.GrandChildEntity;
import com.example.demo.document.SurveyEntity;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.GrandChildRepository;
import com.example.demo.repository.SurveyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTest {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private GrandChildRepository grandChildRepository;

    @BeforeEach
    void cleanUp() {
        surveyRepository.deleteAll();
        childRepository.deleteAll();
        grandChildRepository.deleteAll();
    }

    @Test
    void shouldReturnSurvey_ByGrandChild() {
        var grandChild = grandChildRepository.save(GrandChildEntity.builder()
                .name("grandChild")
                .build());

        var child = childRepository.save(ChildEntity.builder()
                .name("child")
                .grandChild(grandChild)
                .build());

        var survey = surveyRepository.save(SurveyEntity.builder()
                .child(child)
                .name("survey")
                .build());

        var a = surveyRepository.findById(survey.getId());
        assertThat(a).isPresent();

        var b = surveyRepository.findByChildId(child.getId());
        assertThat(b).isPresent();

        /**
         *  This will build:
         *
         * { "_id" : { "$oid" : "65e406c4888148611803bc2b"}, "child" : { "$java" : { "$ref" : "child", "$id" : "65e406c4888148611803bc29" } } }
         *
         *  Insted of
         *
         *                                                                                      ==\/==
         *
         * { "_id" : { "$oid" : "65e406c4888148611803bc2b"}, "child" : { "$java" : { "$ref" : "grandchild", "$id" : "65e406c4888148611803bc29" } } }
         */
        var c = surveyRepository.findByChildGrandChildId(grandChild.getId());
        assertThat(c).isPresent();

        //OR

        var d = surveyRepository.findByIdAndChildGrandChildId(survey.getId(), grandChild.getId());
        assertThat(d).isPresent();
    }

    @Test
    void usingAggregation() {
        var grandChild = grandChildRepository.save(GrandChildEntity.builder()
                .name("grandChild")
                .build());

        var child = childRepository.save(ChildEntity.builder()
                .name("child")
                .grandChild(grandChild)
                .build());

        var survey = surveyRepository.save(SurveyEntity.builder()
                .child(child)
                .name("survey")
                .build());

        var result = surveyRepository.findByAggregation(grandChild.getId());
        assertThat(result).isPresent();
    }


}