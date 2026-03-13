/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techShop.tienda.repository;

import com.techShop.tienda.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author giane
 */

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByActivoTrue();
}

