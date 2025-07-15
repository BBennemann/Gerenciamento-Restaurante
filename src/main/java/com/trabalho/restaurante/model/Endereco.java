package com.trabalho.restaurante.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(int numero, String rua, String bairro, String cidade, String estado, String cep) {
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Cep: " + cep +
                "\nCidade: " + cidade +
                "\nBairro: " + bairro +
                "\nRua: " + rua +
                "\nNúmero: " + numero;
    }
}