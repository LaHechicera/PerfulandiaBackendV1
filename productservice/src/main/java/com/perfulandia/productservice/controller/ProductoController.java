package com.perfulandia.productservice.controller;

import com.perfulandia.productservice.model.Usuario;
import com.perfulandia.productservice.model.Producto;
import com.perfulandia.productservice.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Nuevas importaciones DTO conexion al MS de usuario
import org.springframework.web.client.RestTemplate;
//Herramienta para hacer peticiones a HTTP  a otros microservicios

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService servicio;
    private final RestTemplate restTemplate;
    //final -> esto no va a cambiar durante la ejecucion del proyecto, funciona asi que no tocar si se ve
    public ProductoController(ProductoService servicio, RestTemplate restTemplate) {
        this.servicio = servicio;
        this.restTemplate = restTemplate;
    }

    //Listar
    @GetMapping
    public List<Producto> listar(){
        return servicio.listar();
    }

    //Guardar
    @PostMapping
    public Producto guardar(@RequestBody Producto producto){
        return servicio.guardar(producto);
    }

    //Buscar por id
    @GetMapping("/{id}")
    public Producto buscar(@PathVariable long id){
        return servicio.buscarPorId(id);
    }

    //Eliminar
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id){
        servicio.eliminar(id);
    }

    //Nuevo metodo
    @GetMapping("/usuario/{id}")
    public Usuario obtenerUsuario(@PathVariable long id){
        return restTemplate.getForObject("http://localhost:8081/api/v1/usuarios/"+id, Usuario.class);
    }

}
