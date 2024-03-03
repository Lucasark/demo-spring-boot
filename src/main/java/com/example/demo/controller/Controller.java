package com.example.demo.controller;

import com.example.demo.document.ChildEntity;
import com.example.demo.document.GranChildEntity;
import com.example.demo.document.SurveyEntity;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.GrandChildRepository;
import com.example.demo.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {

    private final SurveyRepository surveyRepository;

    private final ChildRepository childRepository;

    private final GrandChildRepository grandChildRepository;

    @GetMapping
    public void temp() {

        var grandChild = grandChildRepository.save(GranChildEntity.builder()
                .name("grandChild")
                .build());

        var child = childRepository.save(ChildEntity.builder()
                .name("child")
                .granChild(grandChild)
                .build());

        var survey = surveyRepository.save(SurveyEntity.builder()
                .child(child)
                .name("survey")
                .build());

        var result = surveyRepository.findByChildGranChildId(child.getGranChild().getId());

        log.info("AQUI");
    }
}
