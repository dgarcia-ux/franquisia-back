package com.franquisia.franquisia.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*; // Para Spring Boot 3+ usa jakarta.persistence, para versiones anteriores usa javax.persistence
import lombok.*;

@Setter
@Getter
@ToString
@Entity // Marca esta clase como una entidad JPA
@Table(name = "productos") // Nombre de la tabla en la DB
@AllArgsConstructor // Constructor con todos los argumentos
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="sucursal_id", nullable = true)
    private Long idSucursal;

    @Nullable
    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn (name="sucursal_id", referencedColumnName="id", insertable=false, updatable=false)
    private Sucursal sucursal;

    private String nombre;
    private int stock;

    // Constructores
    public Producto() {}

}
