package com.trabalho.restaurante.service;

import com.trabalho.restaurante.model.Cliente;
import com.trabalho.restaurante.model.Pedido;
import com.trabalho.restaurante.model.Pratos;
import com.trabalho.restaurante.model.repository.ClienteRepository;
import com.trabalho.restaurante.model.repository.PedidoRepository;
import com.trabalho.restaurante.model.repository.PratosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PratosRepository pratosRepository;

    public Pedido criarPedido(Long clienteId, List<Long> idsDosPratos) {

        // 1. Validação e busca das entidades
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + clienteId));

        List<Pratos> pratosDoPedido = pratosRepository.findAllById(idsDosPratos);
        if (pratosDoPedido.isEmpty()) {
            throw new RuntimeException("Nenhum prato válido encontrado para os IDs informados!");
        }

        // 2. Criação da entidade principal
        Pedido novoPedido = new Pedido(cliente, pratosDoPedido);

        // 3. Persistência no banco de dados
        return pedidoRepository.save(novoPedido);
    }

    public List<Pedido> listarTodosPedidos() {
        return pedidoRepository.findAll();
    }
}