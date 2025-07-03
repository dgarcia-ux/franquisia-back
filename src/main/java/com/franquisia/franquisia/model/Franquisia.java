package com.franquisia.franquisia.model;

import jakarta.persistence.*; // Para Spring Boot 3+ usa jakarta.persistence, para versiones anteriores usa javax.persistence
import lombok.*;

@Setter
@Getter
@ToString
@Entity // Marca esta clase como una entidad JPA
@Table(name = "franquisias") // Nombre de la tabla en la DB
@AllArgsConstructor // Constructor con todos los argumentos
public class Franquisia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Constructores
    public Franquisia() {}

}
