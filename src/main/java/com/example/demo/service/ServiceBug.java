package com.example.demo.service;

import com.example.demo.document.ChildEntity;
import com.example.demo.document.GranChildEntity;
import com.example.demo.document.SurveyEntity;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.GrandChildRepository;
import com.example.demo.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServiceBug {

    private final SurveyRepository surveyRepository;

    private final ChildRepository childRepository;

    private final GrandChildRepository grandChildRepository;

    public Optional<SurveyEntity> bug() {

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

        return surveyRepository.findByIdAndChildGranChildId(survey.getId(), grandChild.getId());
    }
}
