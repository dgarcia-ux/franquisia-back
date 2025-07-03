package com.franquisia.franquisia.service;

import com.franquisia.franquisia.model.Franquisia;
import com.franquisia.franquisia.pojo.FranquisiaApi;
import com.franquisia.franquisia.repository.FranquisiaRepository;
import com.franquisia.franquisia.repository.SucursalRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service // Marca esta clase como un servicio de Spring
public class FranquisiaService {

    private final FranquisiaRepository franquisiaRepository;
    private final SucursalRepository sucursalRepository;

    public FranquisiaService(FranquisiaRepository franquisiaRepository, SucursalRepository sucursalRepository) {
        this.franquisiaRepository = franquisiaRepository;
        this.sucursalRepository = sucursalRepository;
    }

    // CRUD - Crear una franquisia
    public Franquisia saveFranquisia(Franquisia franquisia) {
        return franquisiaRepository.save(franquisia);
    }

    // CRUD - Obtener todas las franquisias
    public List<FranquisiaApi> obtenerTodosFranquisias() {

        List<FranquisiaApi> listaFranquisiasMap = new ArrayList<>();

        List<Franquisia> listaFranquisias = franquisiaRepository.findAll();

        if (listaFranquisias.isEmpty()) {
            return null;
        } else {
            for (Franquisia item : listaFranquisias) {

                FranquisiaApi franquisiaApi = new FranquisiaApi();
                franquisiaApi.setCanDelete(false);
                if (!sucursalRepository.existsByIdFranquisia(item.getId())) {
                    franquisiaApi.setCanDelete(true);
                }

                franquisiaApi.setId(item.getId());
                franquisiaApi.setNombre(item.getNombre());

                listaFranquisiasMap.add(franquisiaApi);
            }

            return listaFranquisiasMap;
        }

    }

    // CRUD - Obtener franquisia por ID
    public Franquisia obtenerFranquisiaPorId(Long id) {
        return franquisiaRepository.findById(id).orElse(null);
    }

    // CRUD - Eliminar una franquisia
    public void eliminarFranquisia(Long id) {
        if (franquisiaRepository.existsById(id)) {
            franquisiaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Franquisia no encontrada con ID: " + id);
        }
    }

}
