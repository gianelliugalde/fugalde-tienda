/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techShop.tienda.service;

import com.techShop.tienda.domain.Producto;
import java.util.List;
/**
 *
 * @author giane
 */
public interface ProductoService {
    List<Producto> getProductos(boolean activos);
    List<Producto> getProductosPorCategoria(Long idCategoria, boolean activos);
    Producto getProducto(Producto producto);
    void save(Producto producto);
    void delete(Producto producto);

    List<Producto> consultaDerivada(Double precioInf, Double precioSup);
    List<Producto> consultaJPQL(Double precioInf, Double precioSup);
    List<Producto> consultaSQL(Double precioInf, Double precioSup);
    List<Producto> consultaAmpliada(Long idCategoria, Double precioMin, Double precioMax, boolean soloActivos);
}