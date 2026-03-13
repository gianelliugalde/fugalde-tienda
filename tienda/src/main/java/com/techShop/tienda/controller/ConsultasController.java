/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techShop.tienda.controller;

import com.techShop.tienda.service.CategoriaService;
import com.techShop.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author giane
 */
@Controller
@RequestMapping("/consultas")
public class ConsultasController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("productos", productoService.getProductos(false));
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        model.addAttribute("precioInf", 0.0);
        model.addAttribute("precioSup", 1000000.0);
        model.addAttribute("idCategoria", 0L);
        model.addAttribute("precioMin", 0.0);
        model.addAttribute("precioMax", 1000000.0);
        model.addAttribute("soloActivos", false);
        return "/consultas/listado";
    }

    @PostMapping("/consultaDerivada")
    public String consultaDerivada(@RequestParam Double precioInf,
                                   @RequestParam Double precioSup,
                                   Model model) {
        model.addAttribute("productos", productoService.consultaDerivada(precioInf, precioSup));
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        model.addAttribute("idCategoria", 0L);
        model.addAttribute("precioMin", 0.0);
        model.addAttribute("precioMax", 1000000.0);
        model.addAttribute("soloActivos", false);
        return "/consultas/listado";
    }

    @PostMapping("/consultaJPQL")
    public String consultaJPQL(@RequestParam Double precioInf,
                               @RequestParam Double precioSup,
                               Model model) {
        model.addAttribute("productos", productoService.consultaJPQL(precioInf, precioSup));
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        model.addAttribute("idCategoria", 0L);
        model.addAttribute("precioMin", 0.0);
        model.addAttribute("precioMax", 1000000.0);
        model.addAttribute("soloActivos", false);
        return "/consultas/listado";
    }

    @PostMapping("/consultaSQL")
    public String consultaSQL(@RequestParam Double precioInf,
                              @RequestParam Double precioSup,
                              Model model) {
        model.addAttribute("productos", productoService.consultaSQL(precioInf, precioSup));
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        model.addAttribute("idCategoria", 0L);
        model.addAttribute("precioMin", 0.0);
        model.addAttribute("precioMax", 1000000.0);
        model.addAttribute("soloActivos", false);
        return "/consultas/listado";
    }

    @PostMapping("/consultaAmpliada")
    public String consultaAmpliada(@RequestParam Long idCategoria,
                                   @RequestParam Double precioMin,
                                   @RequestParam Double precioMax,
                                   @RequestParam(required = false, defaultValue = "false") boolean soloActivos,
                                   Model model) {
        model.addAttribute("productos", productoService.consultaAmpliada(idCategoria, precioMin, precioMax, soloActivos));
        model.addAttribute("categorias", categoriaService.getCategorias(false));
        model.addAttribute("precioInf", 0.0);
        model.addAttribute("precioSup", 1000000.0);
        model.addAttribute("idCategoria", idCategoria);
        model.addAttribute("precioMin", precioMin);
        model.addAttribute("precioMax", precioMax);
        model.addAttribute("soloActivos", soloActivos);
        return "/consultas/listado";
    }
}