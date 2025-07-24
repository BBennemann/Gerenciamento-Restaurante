package com.trabalho.restaurante.model.repository;

import com.trabalho.restaurante.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Vazio por enquanto!
}
