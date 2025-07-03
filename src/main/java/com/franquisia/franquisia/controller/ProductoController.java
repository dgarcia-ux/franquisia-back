package com.franquisia.franquisia.controller;

import com.franquisia.franquisia.model.Producto;
import com.franquisia.franquisia.pojo.ProductoApi;
import com.franquisia.franquisia.pojos.CustomError;
import com.franquisia.franquisia.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://127.0.0.1:4200"}) // Aplica CORS a todo el controlador
@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @RequestMapping("/api/productos/createProducto")
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productoService.saveProduct(producto);
    }

    @RequestMapping("/api/productos/findAllProductos")
    @PostMapping
    public List<Producto> findAllProductos() { return productoService.obtenerTodosProductos(); }

    @RequestMapping("/api/productos/findProducto")
    @PostMapping
    public Producto findProducto(@RequestParam Long id) { return productoService.obtenerProductoPorId(id); }

    @RequestMapping("/api/productos/deleteProducto")
    @PostMapping
    public CustomError deleteProducto(@RequestParam Long id) {
        CustomError mensaje = new CustomError();
        try {
            productoService.eliminarProducto(id);
            mensaje.setMensaje("Se elimino el producto con exito");
        }  catch (Exception ex) {
            mensaje.setMensaje(ex.getMessage());
        }
        return mensaje;

    }

    @RequestMapping("/api/productos/mayorStock")
    @PostMapping
    public List<ProductoApi> mayorStock(@RequestParam Long id) { return productoService.obtenerProductosConMasStockPorSucursalParaFranquicia(id); }

}
