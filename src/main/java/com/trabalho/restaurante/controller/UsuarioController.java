package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.DAO.IUsuario;
import com.trabalho.restaurante.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuario dao;

    @GetMapping
    public List<Usuario> listaUsuarios() {
        return (List<Usuario>) dao.findAll();
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioNovo = dao.save(usuario);
        return usuarioNovo;
    }

    @PutMapping
    public Usuario alterarUsuario (@RequestBody Usuario usuario) {
        Usuario usuarioEditado = dao.save(usuario);
                return usuarioEditado;
    }

    @DeleteMapping("/{id}")
    public Optional<Usuario> deletarUsuario(@PathVariable Integer id) {
        Optional<Usuario> usuario = dao.findById(id);
        dao.deleteAllById(Collections.singleton(id));
        return usuario;
    }
}
