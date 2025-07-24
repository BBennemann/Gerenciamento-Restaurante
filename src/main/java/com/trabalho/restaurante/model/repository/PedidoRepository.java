package com.trabalho.restaurante.model.repository;

import com.trabalho.restaurante.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para gerenciar a entidade Pedido.
 * Com ele, podemos salvar, buscar, atualizar e deletar pedidos no banco de dados.
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // O corpo fica vazio para as operações padrão de CRUD.

    // No futuro, você poderia adicionar métodos de busca customizados, como:
    // List<Pedido> findByCliente(Cliente cliente); // Para buscar todos os pedidos de um cliente específico
    // List<Pedido> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim); // Para relatórios
}
