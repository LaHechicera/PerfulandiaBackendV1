package com.perfulandia.pedidoservice.controller;

import com.perfulandia.pedidoservice.model.Pedido;
import com.perfulandia.pedidoservice.model.Carrito;
import com.perfulandia.pedidoservice.service.PedidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService service;
    private final RestTemplate restTemplate;

    public PedidoController(PedidoService service, RestTemplate restTemplate) {
        this.service = service;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Pedido> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Carrito buscar(@PathVariable long id) {
        return restTemplate.getForObject("http://localhost:8083/carrito/producto/" + id, Carrito.class);
    }

}
