package Ejercicio2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class CsvModel implements Serializable {

    private String comunidadAutonoma;
    private String gruposEspeciales;
    private int periodo;
    private double total;

    @Override
    public String toString() {
        return "\ncomunidadAutonoma = '" + comunidadAutonoma + '\'' +
                " gruposEspeciales = '" + gruposEspeciales + '\'' +
                " periodo = " + periodo +
                " total = " + total;
    }

    public int compareTo(@NotNull CsvModel c){
        if (total>c.total){
            return 1;
        }
        if (total<c.total){
            return -1;
        }
        return 0;
    }

}
