package com.franquisia.franquisia.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "sucursales") // Nombre de la tabla en la DB
@AllArgsConstructor // Constructor con todos los argumentos
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="franquisia_id", nullable = true)
    private Long idFranquisia;

    @Nullable
    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn (name="franquisia_id", referencedColumnName="id", insertable=false, updatable=false)
    private Franquisia franquisia;


    private String nombre;



    // Constructores
    public Sucursal() {}

}
