package com.franquisia.franquisia.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FranquisiaApi {

    private Long id;

    private String nombre;

    private Boolean canDelete;

    // Constructores
    public FranquisiaApi() {}
}
