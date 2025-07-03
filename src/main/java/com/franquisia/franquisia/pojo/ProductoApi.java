package com.franquisia.franquisia.pojo;

import com.franquisia.franquisia.model.Franquisia;
import com.franquisia.franquisia.model.Sucursal;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductoApi {

    private String nombreProducto;
    private int stock;
    private String nombreSucursal;
    private String nombreFranquicia;

    // Constructor: Asegúrate de que sea PUBLIC y que los tipos y el orden coincidan.
    public ProductoApi(String nombreProducto, int stock, String nombreSucursal, String nombreFranquicia) {
        this.nombreProducto = nombreProducto;
        this.stock = stock;
        this.nombreSucursal = nombreSucursal;
        this.nombreFranquicia = nombreFranquicia;
    }

    // Getters (necesarios para que Jackson/Spring lo serialice a JSON)
    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getStock() {
        return stock;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public String getNombreFranquicia() {
        return nombreFranquicia;
    }

}
