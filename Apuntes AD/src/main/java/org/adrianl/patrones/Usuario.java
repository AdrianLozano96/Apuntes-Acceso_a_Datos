package org.adrianl.patrones;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class Usuario {
    private String nombre;
    private String email;
    private String password;
    private LocalDate fecha;
}
