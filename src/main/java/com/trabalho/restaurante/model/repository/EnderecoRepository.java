package com.trabalho.restaurante.model.repository;

import com.trabalho.restaurante.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
//    save(endereco): Salva um novo endereço ou atualiza um existente.
//
//    findById(id): Busca um endereço pelo seu ID.
//
//    findAll(): Retorna uma lista com todos os endereços do banco.
//
//    deleteById(id): Apaga um endereço pelo seu ID.
//
//    count(): Conta quantos endereços existem na tabela.
}