package org.adrianl.patrones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioBuilder {

    List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario>misUsers(){

        Usuario u1 = Usuario.builder()
                .nombre("Paco")
                .email("paco@pac.com")
                .password("Paco123")
                .fecha(LocalDate.now())
                .build();
        Usuario u2 = Usuario.builder()
                .nombre("Maria")
                .email("maria@ma.com")
                .password("Paco123")
                .fecha(LocalDate.now())
                .build();
        Usuario u3 = Usuario.builder()
                .nombre("Jose")
                .email("jose@jo.com")
                .password("Jose123")
                .fecha(LocalDate.now())
                .build();

        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);

        return usuarios;
    }

    public static void main(String[] args) {
        UsuarioBuilder ub = new UsuarioBuilder();
        System.out.println(ub.misUsers());
    }

}


