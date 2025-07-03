package com.franquisia.franquisia.service;

import com.franquisia.franquisia.model.Franquisia;
import com.franquisia.franquisia.model.Producto;
import com.franquisia.franquisia.model.Sucursal;
import com.franquisia.franquisia.pojo.FranquisiaApi;
import com.franquisia.franquisia.pojo.SucursalApi;
import com.franquisia.franquisia.repository.ProductoRepository;
import com.franquisia.franquisia.repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // Marca esta clase como un servicio de Spring
public class SucursalService {

    private final SucursalRepository sucursalRepository; // Necesario para asociar productos a sucursales
    private final ProductoRepository productoRepository;

    public SucursalService(SucursalRepository sucursalRepository, ProductoRepository productoRepository) {
        this.sucursalRepository = sucursalRepository;
        this.productoRepository = productoRepository;
    }

    // CRUD - Crear una sucursal
    public Sucursal saveSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    // CRUD - Obtener todas las sucursales
    public List<SucursalApi> obtenerTodosSucursales() {

        List<SucursalApi> listaSucursalesMap = new ArrayList<>();

        List<Sucursal> listaSucursales = sucursalRepository.findAll();

        if (listaSucursales.isEmpty()) {
            return null;
        } else {
            for (Sucursal item : listaSucursales) {

                SucursalApi sucursalApi = new SucursalApi();
                sucursalApi.setCanDelete(false);
                if (!productoRepository.existsByIdSucursal(item.getId())) {
                    sucursalApi.setCanDelete(true);
                }

                sucursalApi.setId(item.getId());
                sucursalApi.setIdFranquisia(item.getIdFranquisia());
                sucursalApi.setFranquisia(item.getFranquisia());
                sucursalApi.setNombre(item.getNombre());

                listaSucursalesMap.add(sucursalApi);
            }

            return listaSucursalesMap;
        }

    }

    // CRUD - Obtener sucursal por ID
    public Sucursal obtenerSucursalPorId(Long id) {
        return sucursalRepository.findById(id).orElse(null);
    }

    // CRUD - Eliminar un sucursal
    public void eliminarSucursal(Long id) {
        if (sucursalRepository.existsById(id)) {
            sucursalRepository.deleteById(id);
        } else {
            throw new RuntimeException("Sucursal no encontrado con ID: " + id);
        }
    }
}
