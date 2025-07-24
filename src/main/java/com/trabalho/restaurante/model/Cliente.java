package com.trabalho.restaurante.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // Essencial para o JPA
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;

    @Column(unique = true) // Boa prática: garantir que não haja emails repetidos
    private String email;

    private String senha;

    // --- AQUI ESTÁ O RELACIONAMENTO ---
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    // ---------------------------------

    public Cliente(String nome, int idade, String email, String senha, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }
}