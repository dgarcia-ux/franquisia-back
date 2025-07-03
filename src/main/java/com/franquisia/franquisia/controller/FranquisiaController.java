package com.franquisia.franquisia.controller;

import com.franquisia.franquisia.model.Franquisia;
import com.franquisia.franquisia.pojo.FranquisiaApi;
import com.franquisia.franquisia.pojos.CustomError;
import com.franquisia.franquisia.service.FranquisiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://127.0.0.1:4200"}) // Aplica CORS a todo el controlador
@RestController
public class FranquisiaController {

    @Autowired
    private FranquisiaService franquisiaService;

    @RequestMapping("/api/franquisias/createFranquisia")
    @PostMapping
    public Franquisia createFranquisia(@RequestBody Franquisia franquisia) {
        return franquisiaService.saveFranquisia(franquisia);
    }

    @RequestMapping("/api/franquisias/findAllFranquisias")
    @PostMapping
    public List<FranquisiaApi> findAllFranquisias() { return franquisiaService.obtenerTodosFranquisias(); }

    @RequestMapping("/api/franquisias/findFranquisia")
    @PostMapping
    public Franquisia findFranquisia(@RequestParam Long id) { return franquisiaService.obtenerFranquisiaPorId(id); }

    @RequestMapping("/api/franquisias/deleteFranquisia")
    @PostMapping
    public CustomError deleteFranquisia(@RequestParam Long id) {
        CustomError mensaje = new CustomError();
        try {
            franquisiaService.eliminarFranquisia(id);
            mensaje.setMensaje("Se elimino la franquisia con exito");
        }  catch (Exception ex) {
            mensaje.setMensaje(ex.getMessage());
        }
        return mensaje;

    }

}
