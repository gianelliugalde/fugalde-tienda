/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techShop.tienda.service.impl;

import com.techShop.tienda.domain.Producto;
import com.techShop.tienda.repository.ProductoRepository;
import com.techShop.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author giane
 */

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos(boolean activos) {
        return activos ? productoRepository.findByActivoTrue() : productoRepository.findAll();
    }

    @Override
    public List<Producto> getProductosPorCategoria(Long idCategoria, boolean activos) {
        return activos
                ? productoRepository.findByCategoriaIdCategoriaAndActivoTrue(idCategoria)
                : productoRepository.findByCategoriaIdCategoria(idCategoria);
    }

    @Override
    public Producto getProducto(Producto producto) {
        return productoRepository.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    public void save(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void delete(Producto producto) {
        productoRepository.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaDerivada(Double precioInf, Double precioSup) {
        return productoRepository.findByPrecioBetweenOrderByPrecioAsc(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaJPQL(Double precioInf, Double precioSup) {
        return productoRepository.consultaJPQL(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaSQL(Double precioInf, Double precioSup) {
        return productoRepository.consultaSQL(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaAmpliada(Long idCategoria, Double precioMin, Double precioMax, boolean soloActivos) {
        return productoRepository.consultaAmpliada(idCategoria, precioMin, precioMax, soloActivos);
    }
}