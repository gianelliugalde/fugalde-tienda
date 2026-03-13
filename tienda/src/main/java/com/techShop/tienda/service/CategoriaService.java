/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techShop.tienda.service;

import com.techShop.tienda.domain.Categoria;
import java.util.List;
/**
 *
 * @author giane
 */
public interface CategoriaService {
    List<Categoria> getCategorias(boolean activos);
    Categoria getCategoria(Categoria categoria);
    void save(Categoria categoria);
    void delete(Categoria categoria);
}