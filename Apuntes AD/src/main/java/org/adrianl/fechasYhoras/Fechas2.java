package org.adrianl.fechasYhoras;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Fechas2 {
    public static void main(String[] args) {
        // Obtenemos la fecha de hoy con now
        LocalDate today = LocalDate.now();

        // Obtenemos una fecha cualquiera con el método of(...)
        LocalDate otraFecha = LocalDate.of(2021, 9, 2);

        // Comprobamos si una fecha es anterior a otra
        if (otraFecha.isAfter(today)) {
            System.out.println("La otra fecha es posterior a la de hoy");
        }

        // Obtenemos la fecha de ayer, restando un día a la de hoy
        LocalDate ayer = today.minus(1, ChronoUnit.DAYS);
        if (ayer.isBefore(today)) {
            System.out.println("Ayer es anterior a hoy");
        }

        // Es el año actual bisiesto?
        System.out.println("El año actual " + (LocalDate.now().isLeapYear() ? "sí" : "no") + " es bisiesto");

        // Imprimimos el valor de otraFecha con su transformación por defecto
        System.out.println(otraFecha);

        //LocalDate otraFecha = LocalDate.of(2021, 9, 2);
        // Ahora, lo imprimimos formateando la misma a un formato LARGO
        System.out.println(otraFecha.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));

        // Por último, imprimimos la fecha de hoy en un formato proporcionado en una cadena
        System.out.println(otraFecha.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
    }
}
