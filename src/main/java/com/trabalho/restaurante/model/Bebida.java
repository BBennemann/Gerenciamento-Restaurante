package com.trabalho.restaurante.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bebida extends Pratos{
    private boolean isAlcoolica;
    private int volume;

    public Bebida(int id, String nome, double preco, boolean isAlcoolica, int volume, String imagens, double avaliacao) {
        super(id, nome, preco, imagens, avaliacao);
        this.isAlcoolica = isAlcoolica;
        this.volume = volume;
    }

    public Bebida(String nome, double preco, boolean isAlcoolica, int volume, String imagens, double avaliacao) {
        super(nome, preco, imagens, avaliacao);
        this.isAlcoolica = isAlcoolica;
        this.volume = volume;

    }

    @Override
    public String descricao() {
        return String.format(
                "%s %s\n" +
                        "Uma bebida %s, servida em %d ml, perfeita para acompanhar qualquer ocasião com estilo e sabor.\n" +
                        "%s\n" +
                        "Preço: R$ %.2f\n",
                this.getNome(),
                isAlcoolica ? "(Alcoólica)" : "(Não Alcoólica)",
                isAlcoolica ? "refrescante e sofisticada, ideal para momentos de descontração" :
                        "refrescante e leve, ideal para todas as idades",
                volume,
                isAlcoolica
                        ? "Indicada para apreciadores de sabores marcantes e experiências únicas."
                        : "Uma escolha versátil que agrada a todos os paladares, a qualquer hora do dia.",
                this.getPreco()
        );
    }
}