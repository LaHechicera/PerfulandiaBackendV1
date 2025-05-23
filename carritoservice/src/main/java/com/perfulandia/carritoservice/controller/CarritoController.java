package com.perfulandia.carritoservice.controller;

import com.perfulandia.carritoservice.model.Producto;
import com.perfulandia.carritoservice.model.Carrito;
import com.perfulandia.carritoservice.service.CarritoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    private final CarritoService servicio;
    private final RestTemplate restTemplate;
    //final -> esto no va a cambiar durante la ejecucion del proyecto, funciona asi que no tocar si se ve

    public CarritoController(CarritoService servicio, RestTemplate restTemplate) {
        this.servicio = servicio;
        this.restTemplate = restTemplate;
    }

    //Listar
    @GetMapping
    public List<Carrito> listar() {
        return servicio.listar();
    }
    //buscar por id
    @GetMapping("/{id}")
    public Carrito buscar(@PathVariable long id) {
        return servicio.bucscarId(id);
    }

    //Guardar datos
    @PostMapping
    public Carrito guardar(@RequestBody Carrito carrito) {
        return servicio.guardar(carrito);
    }
    //Eliminar carritos por id
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id) {
        servicio.eliminar(id);
    }

    //Listar productos desde MS Producto
    @GetMapping("/producto/lista")
    public Producto[] productos() {
        return restTemplate.getForObject("http://localhost:8082/api/productos", Producto[].class);
    }

}
