package com.trabalho.restaurante.model.repository;

import com.trabalho.restaurante.model.Pratos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Este é o ÚNICO repositório necessário para gerenciar todos os tipos de pratos.
 * Ele funciona como o "Gerente do Cardápio", capaz de lidar com
 * PratoPrincipal, Sobremesa e Bebida, pois todos são "Pratos".
 */
@Repository
public interface PratosRepository extends JpaRepository<Pratos, Long> {

    // O corpo fica vazio para as operações padrão de CRUD.
    // O Spring Data JPA cuida de tudo.

    // No futuro, se precisar de uma busca customizada, como "buscar todos os
    // pratos com avaliação maior que X", você adicionaria o método aqui.
    // Ex: List<Pratos> findByAvaliacaoGreaterThan(double avaliacao);
}