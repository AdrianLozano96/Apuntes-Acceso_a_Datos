package Ejercicio1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CsvModel implements Serializable {

    private String comunidadAutonoma;
    private String gruposEspeciales;
    private String periodo;
    private double total;

    @Override
    public String toString() {
        return "\nCsvModel con los datos: " +
                "comunidadAutonoma = '" + comunidadAutonoma + '\'' +
                ", gruposEspeciales = '" + gruposEspeciales + '\'' +
                ", periodo = " + periodo +
                ", total = " + total;
    }
}
