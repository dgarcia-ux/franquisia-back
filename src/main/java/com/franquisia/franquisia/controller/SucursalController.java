package com.franquisia.franquisia.controller;

import com.franquisia.franquisia.model.Sucursal;
import com.franquisia.franquisia.pojo.SucursalApi;
import com.franquisia.franquisia.pojos.CustomError;
import com.franquisia.franquisia.service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://127.0.0.1:4200"}) // Aplica CORS a todo el controlador
@RestController
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @RequestMapping("/api/sucursales/createSucursal")
    @PostMapping
    public Sucursal createSucursal(@RequestBody Sucursal sucursal) {
        return sucursalService.saveSucursal(sucursal);
    }

    @RequestMapping("/api/sucursales/findAllSucursales")
    @PostMapping
    public List<SucursalApi> findAllSucursales() { return sucursalService.obtenerTodosSucursales(); }

    @RequestMapping("/api/sucursales/findSucursal")
    @PostMapping
    public Sucursal findSucursal(@RequestParam Long id) { return sucursalService.obtenerSucursalPorId(id); }

    @RequestMapping("/api/sucursales/deleteSucursal")
    @PostMapping
    public CustomError deleteSucursal(@RequestParam Long id) {
        CustomError mensaje = new CustomError();
        try {
            sucursalService.eliminarSucursal(id);
            mensaje.setMensaje("Se elimino la sucursal con exito");
        }  catch (Exception ex) {
            mensaje.setMensaje(ex.getMessage());
        }
        return mensaje;

    }

}
