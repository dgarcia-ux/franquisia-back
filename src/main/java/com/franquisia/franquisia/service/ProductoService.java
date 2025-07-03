package com.franquisia.franquisia.service;

import com.franquisia.franquisia.model.Producto;
import com.franquisia.franquisia.model.Sucursal;
import com.franquisia.franquisia.pojo.ProductoApi;
import com.franquisia.franquisia.repository.ProductoRepository;
import com.franquisia.franquisia.repository.SucursalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Marca esta clase como un servicio de Spring
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final SucursalRepository sucursalRepository; // Necesario para asociar productos a sucursales

    public ProductoService(ProductoRepository productoRepository, SucursalRepository sucursalRepository) {
        this.productoRepository = productoRepository;
        this.sucursalRepository = sucursalRepository;
    }

    // CRUD - Crear un producto
    public Producto saveProduct(Producto producto) {
        return productoRepository.save(producto);
    }

    // CRUD - Obtener todos los productos
    public List<Producto> obtenerTodosProductos() {
        return productoRepository.findAll();
    }

    // CRUD - Obtener producto por ID
    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    // CRUD - Eliminar un producto
    public void eliminarProducto(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
    }

    public List<ProductoApi> obtenerProductosConMasStockPorSucursalParaFranquicia(Long idFranquicia) {
        return productoRepository.buscarProductosConMasStockPorSucursalParaFranquicia(idFranquicia);
    }

}
