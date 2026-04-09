/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techShop.tienda.controller;


import com.techShop.tienda.domain.Categoria;
import com.techShop.tienda.service.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        return "/categoria/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Categoria categoria) {
        return "/categoria/modifica";
    }

    @PostMapping("/guardar")
    public String guardar(Categoria categoria) {
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/eliminar/{idCategoria}")
    public String eliminar(@PathVariable("idCategoria") Long idCategoria) {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idCategoria}")
    public String modificar(@PathVariable("idCategoria") Long idCategoria, Model model) {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }
}

