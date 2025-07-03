package com.franquisia.franquisia.pojo;

import com.franquisia.franquisia.model.Franquisia;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SucursalApi {

    private Long id;

    private Long idFranquisia;

    private Franquisia franquisia;

    private String nombre;

    private Boolean canDelete;

    // Constructores
    public SucursalApi() {}

}
