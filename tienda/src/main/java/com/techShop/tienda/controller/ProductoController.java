/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techShop.tienda.controller;

import com.techShop.tienda.domain.Producto;
import com.techShop.tienda.service.CategoriaService;
import com.techShop.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author giane
 */

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("productos", productoService.getProductos(false));
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        return "/producto/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Producto producto, Model model) {
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        return "/producto/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(Producto producto) {
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String eliminar(@PathVariable("idProducto") Long idProducto) {
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String modificar(@PathVariable("idProducto") Long idProducto, Model model) {
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        return "/producto/modifica";
    }
} 

