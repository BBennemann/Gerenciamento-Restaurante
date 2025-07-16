package com.trabalho.restaurante.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pratos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_prato", discriminatorType = DiscriminatorType.STRING)
public abstract class Pratos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double preco;
    private String imagens;
    private double avaliacao;

    public Pratos(String nome, double preco, String imagens, double avaliacao) {
        this.nome = nome;
        this.preco = preco;
        this.imagens = imagens;
        this.avaliacao = avaliacao;
    }

    public abstract String descricao();
}