package org.adrianl.rss;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User { //CABIAR NOMBRE POR NOTICIAS
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
}
