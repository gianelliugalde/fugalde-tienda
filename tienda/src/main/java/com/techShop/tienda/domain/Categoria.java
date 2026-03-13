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
@Table(name="categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    private String descripcion;
    private String rutaImagen;
    private boolean activo;
}