package com.perfulandia.pedidoservice.controller;

import com.perfulandia.pedidoservice.model.Pedido;
import com.perfulandia.pedidoservice.model.Carrito;
import com.perfulandia.pedidoservice.service.PedidoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping("/api/pedido")
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

    @PostMapping
    public Pedido enviar (@RequestBody Pedido pedido) {
        return service.guardar(pedido);
    }

    @GetMapping("/estado/{id}")
    public Carrito estado (@PathVariable long id) {
        return restTemplate.getForObject("http://localhost:8083/api/carrito/"+id,Carrito.class);
    }

    //Listar productos
    @GetMapping("/estado")
    public Carrito[] productos() {
        return restTemplate.getForObject("http://localhost:8083/api/carrito", Carrito[].class);
    }

    @PostMapping("/generar")
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return service.guardar(pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id) {
        service.eliminar(id);
    }

}
