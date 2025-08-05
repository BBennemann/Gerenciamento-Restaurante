package com.trabalho.restaurante.service;

import com.trabalho.restaurante.model.Pratos;
import com.trabalho.restaurante.model.repository.PratosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardapioService {

    @Autowired
    private PratosRepository pratosRepository;

    public List<Pratos> getCardapioCompleto() {
        return pratosRepository.findAll();
    }
}