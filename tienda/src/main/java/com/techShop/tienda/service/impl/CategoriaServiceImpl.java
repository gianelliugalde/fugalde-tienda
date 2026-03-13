/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techShop.tienda.service.impl;

import com.techShop.tienda.domain.Categoria;
import com.techShop.tienda.repository.CategoriaRepository;
import com.techShop.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author giane
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> getCategorias(boolean activos) {
        return activos ? categoriaRepository.findByActivoTrue() : categoriaRepository.findAll();
    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
        return categoriaRepository.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public void delete(Categoria categoria) {
        categoriaRepository.delete(categoria);
    }
}