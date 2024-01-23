package com.example.demo.service.impl;

import com.example.demo.repository.EstadoRepository;
import com.example.demo.service.EstadoService;
import com.example.demo.util.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstadoServiceImpl implements EstadoService {

    private final EstadoRepository estadoRepository;

    private final Converter converter;

}
