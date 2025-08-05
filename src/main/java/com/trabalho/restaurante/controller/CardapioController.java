package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.model.Pratos;
import com.trabalho.restaurante.service.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
@CrossOrigin(origins = "http://localhost:5173")
public class CardapioController {

    @Autowired
    private CardapioService cardapioService;

    @GetMapping
    public List<Pratos> listarCardapio() {
        return cardapioService.getCardapioCompleto();
    }
}