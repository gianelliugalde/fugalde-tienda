/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techShop.tienda.domain;

import jakarta.persistence.*;
import lombok.Data;
/**
 *
 * @author giane
 */
@Data
@Entity
@Table(name="producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;

    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;
}