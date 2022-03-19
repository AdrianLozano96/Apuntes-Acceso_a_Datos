package org.adrianl.streamMios;

import java.util.Objects;

public class Paises {

    private int prefijo;
    private String nombre;
    private String idioma;

    public Paises(int prefijo, String nombre, String idioma) {
        this.prefijo = prefijo;
        this.nombre = nombre;
        this.idioma = idioma;
    }

    public int getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(int prefijo) {
        this.prefijo = prefijo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return  '\n'+ "El prefijo " + prefijo +
                " pertenece al pais " + nombre +
                " donde se habla el idioma " + idioma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paises paises = (Paises) o;
        return prefijo == paises.prefijo && Objects.equals(nombre, paises.nombre) && Objects.equals(idioma, paises.idioma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefijo, nombre, idioma);
    }


    public int compareTo(Paises p) {
        if ( prefijo< p.prefijo) {
            return -1;
        }
        if (prefijo > p.prefijo) {
            return 1;
        }
        return 0;
    }


}
