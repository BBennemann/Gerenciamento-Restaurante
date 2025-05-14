package com.trabalho.restaurante.DAO;

import com.trabalho.restaurante.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuario extends CrudRepository<Usuario, Integer> {
}
