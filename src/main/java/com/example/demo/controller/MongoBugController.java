package com.example.demo.controller;

import com.example.demo.response.MongoBugResponse;
import com.example.demo.response.MongoBugWorkaroundResponse;
import com.example.demo.repository.PaisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mongo")
@RequiredArgsConstructor
public class MongoBugController {

    private final PaisRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<List<MongoBugResponse>> getBug(
            @PathVariable("id") String id
    ) {
        var r = repository.getEntity(id);
        return ResponseEntity.ok(r);
    }

    @GetMapping("/{id}/workaround")
    public ResponseEntity<List<MongoBugWorkaroundResponse>> getBug2(
            @PathVariable("id") String id
    ) {
        var r = repository.getEntityDiffId(id);
        return ResponseEntity.ok(r);
    }
}
