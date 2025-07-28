package com.trabalho.restaurante.controller;

import com.trabalho.restaurante.model.Pedido;
import com.trabalho.restaurante.service.PedidoService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodosPedidos();
    }

    @PostMapping
    public ResponseEntity<Pedido> criar(@RequestBody PedidoRequest request) {
        Pedido novoPedido = pedidoService.criarPedido(request.getClienteId(), request.getIdsDosPratos());
        return ResponseEntity.ok(novoPedido);
    }

    @Setter
    @Getter
    public static class PedidoRequest {
        private Long clienteId;
        private List<Long> idsDosPratos;
    }
}