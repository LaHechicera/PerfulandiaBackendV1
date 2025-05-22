package com.perfulandia.carritoservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder //Permite crear objetos de manera flexible = constructor flexible
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String metodoPago;
    private double cantidadProductos;
    private double precioTotal;
}

//buscar por codigo, eliminar, agregar, listar