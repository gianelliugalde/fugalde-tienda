/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techShop.tienda.repository;

import com.techShop.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author giane
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByActivoTrue();

    List<Producto> findByCategoriaIdCategoria(Long idCategoria);

    List<Producto> findByCategoriaIdCategoriaAndActivoTrue(Long idCategoria);

    List<Producto> findByPrecioBetweenOrderByPrecioAsc(Double precioInf, Double precioSup);

    @Query("SELECT p FROM Producto p WHERE p.precio BETWEEN :precioInf AND :precioSup ORDER BY p.precio ASC")
    List<Producto> consultaJPQL(Double precioInf, Double precioSup);

    @Query(value = """
            SELECT *
            FROM producto p
            WHERE p.precio BETWEEN :precioInf AND :precioSup
            ORDER BY p.precio ASC
            """, nativeQuery = true)
    List<Producto> consultaSQL(Double precioInf, Double precioSup);

    @Query("""
           SELECT p
           FROM Producto p
           WHERE (:idCategoria = 0 OR p.categoria.idCategoria = :idCategoria)
             AND p.precio >= :precioMin
             AND p.precio <= :precioMax
             AND (:soloActivos = false OR p.activo = true)
           ORDER BY p.precio ASC
           """)
    List<Producto> consultaAmpliada(Long idCategoria, Double precioMin, Double precioMax, boolean soloActivos);
}