package com.trabalho.restaurante.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor // Essencial para o JPA
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- RELACIONAMENTO 1: Muitos para Um ---
    // Muitos Pedidos podem pertencer a UM Cliente.
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false) // A coluna de junção no banco. nullable=false garante que todo pedido TEM um cliente.
    private Cliente cliente;

    // --- RELACIONAMENTO 2: Muitos para Muitos ---
    // Um Pedido pode ter Muitos Pratos, e um Prato pode estar em Muitos Pedidos.
    @ManyToMany
    @JoinTable(
            name = "pedido_pratos", // Nome da tabela intermediária que será criada
            joinColumns = @JoinColumn(name = "pedido_id"), // Coluna que referencia o Pedido
            inverseJoinColumns = @JoinColumn(name = "prato_id") // Coluna que referencia o Prato
    )
    private List<Pratos> itens;

    private double valorTotal;

    private LocalDateTime dataHora;

    // Construtor para criar um novo pedido
    public Pedido(Cliente cliente, List<Pratos> itens) {
        this.cliente = cliente;
        this.itens = itens;
        // Calcula o valor total somando o preço de cada item na lista
        this.valorTotal = itens.stream().mapToDouble(Pratos::getPreco).sum();
    }

    @PrePersist
    public void prePersist() {
        this.dataHora = LocalDateTime.now();
    }
}