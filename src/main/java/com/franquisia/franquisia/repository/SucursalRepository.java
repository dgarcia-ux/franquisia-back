package com.franquisia.franquisia.repository;

import com.franquisia.franquisia.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

    public boolean existsByIdFranquisia(Long id);

}
