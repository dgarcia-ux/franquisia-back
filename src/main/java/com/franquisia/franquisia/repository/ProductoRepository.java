package com.franquisia.franquisia.repository;

import com.franquisia.franquisia.model.Producto;
import com.franquisia.franquisia.pojo.ProductoApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    public boolean existsByIdSucursal(Long id);

    @Query("SELECT new com.franquisia.franquisia.pojo.ProductoApi(" + // Asegúrate de usar el paquete real de tu DTO
            "p.nombre, p.stock, s.nombre, f.nombre) " +
            "FROM Producto p " +
            "JOIN p.sucursal s " +
            "JOIN s.franquisia f " +
            "WHERE f.id = :idFranquicia " +
            "AND p.stock = (SELECT MAX(p2.stock) FROM Producto p2 WHERE p2.sucursal.id = s.id)")
    List<ProductoApi> buscarProductosConMasStockPorSucursalParaFranquicia(@Param("idFranquicia") Long idFranquicia);
}
