package org.adrianl.fechasYhoras;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Fechas1 {

    public static void main(String[] args) {
        //Fecha actual
        LocalDate hoy = LocalDate.now();
        System.out.println("La fecha actual es : " + hoy);
        //Año, Mes y Día actuales
        int year = hoy.getYear();
        int month = hoy.getMonthValue();
        int day = hoy.getDayOfMonth();
        System.out.println("Año: "+year+" Mes: "+ month+" Dia: "+day);
        //Fecha en concreto
        LocalDate nacimiento = LocalDate.of(1996, 11, 9);
        System.out.println("Tu fecha de nacimiento es : " + nacimiento);
        //Fechas iguales
        LocalDate fechai = LocalDate.of(2021, 10, 2);
        LocalDate hoyi = LocalDate.now();
        if (fechai.equals(hoyi)) {
            System.out.printf("Hoy %s y la fecha %s son la misma fecha", hoyi, fechai);
        } else {
            System.out.println("Las fechas no son iguales");
        }
        //Eventos saber si una fecha es el día de hoy
        MonthDay diaNacimiento = MonthDay.of(nacimiento.getMonth(), nacimiento.getDayOfMonth());
        MonthDay diaMesHoy = MonthDay.from(LocalDate.now());
        if (diaMesHoy.equals(diaNacimiento)) {
            System.out.println("Muchas felicidades, porque es tu cumpleaños");
        } else {
            System.out.println("Lo siento, pero no es tu cumpleaños");
        }


        //Hora actual
        LocalTime time = LocalTime.now();
        System.out.println("La hora actual es : " + time);
        //Añadir horas
        LocalTime newTime = time.plusHours(2); // añadiendo dos horas
        System.out.println("Hora, después de 2 horas : " + newTime);


        //Una semana después
        LocalDate nextWeek = LocalDate.now().plus(1, ChronoUnit.WEEKS);
        System.out.println("Hoy es : " + LocalDate.now());
        System.out.println("Dentro de 1 semana: " + nextWeek);
        //La fecha de hoy hace un año y dentro de un año
        LocalDate today = LocalDate.now();
        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println("Fecha hace un año: " + previousYear);
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Fecha dentro de 1 año : " + nextYear);
        //Compara Fechas
        LocalDate otraFecha = LocalDate.of(2021, 10, 2);
        if (otraFecha.isAfter(today)) {
            System.out.println("La otra fecha es posterior a la de hoy");
        }
        LocalDate ayer = today.minus(1, ChronoUnit.DAYS);
        if (ayer.isBefore(today)) {
            System.out.println("Ayer es anterior a hoy");
        }
        //Fechas Fijas con YearMonth
        YearMonth anioYMesActual = YearMonth.now();
        System.out.printf("Días en la clase MonthYear %s: %d%n", anioYMesActual, anioYMesActual.lengthOfMonth());
        YearMonth caducidadTarjetaCredito = YearMonth.of(2028, Month.FEBRUARY);
        System.out.printf("Su tarjeta de crédito caduca en %s ", caducidadTarjetaCredito);
        //Bisiesto
        LocalDate bisiesto = LocalDate.now();
        if (bisiesto.isLeapYear()) {
            System.out.println("Este año es bisiesto");
        } else {
            System.out.println("Este año no es bisiesto");
        }
        //Periodo de tiempo
        LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
        LocalDate java9Release = LocalDate.of(2017, Month.SEPTEMBER, 27);
        Period periodToNextJavaRelease = Period.between(java8Release, java9Release);
        System.out.println("Meses transcurridos entre la liberación de Java 8 y Java 9 : " + periodToNextJavaRelease.toTotalMonths());


        //Cambiar Formato de String a Fecha
        String diaDespuesDeHoy = "20211002";
        LocalDate formateada = LocalDate.parse(diaDespuesDeHoy, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("La fecha generada de un String %s es %s %n", diaDespuesDeHoy, formateada);

        String viernes = "20/06/2010";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate holiday = LocalDate.parse(viernes, formatter);
            System.out.printf("Cadena formateada correctamente %s, la fecha es %s%n", viernes, holiday);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s no es parseable!%n", viernes);
            ex.printStackTrace();
        }
        //Cambiar Fecha a String
        LocalDateTime fechaLlegada = LocalDateTime.now();
        System.out.println("FIN: "+fechaLlegada);
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");
            String landing = fechaLlegada.format(format);
            System.out.printf("Llegada a : %s %n", landing);
        } catch (DateTimeException ex) {
            System.out.printf("%s no puede ser formateada!%n", fechaLlegada);
            ex.printStackTrace();
        }



    }
}
