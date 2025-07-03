package com.franquisia.franquisia.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CustomError {

    String mensaje;
    String codigo;

    public CustomError() {

    }
}
