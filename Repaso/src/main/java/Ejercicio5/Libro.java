package Ejercicio5;

import javax.xml.bind.annotation.XmlType;

//
@XmlType(propOrder = {"autor", "nombre", "editorial", "isbn"})
public class Libro {
    private String autor;
    private String nombre;
    private String editorial;
    private String isbn;

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Libro(){}
    public Libro(String autor, String nombre, String editorial, String isbn) {
        super();
        this.autor = autor;
        this.nombre = nombre;
        this.editorial = editorial;
        this.isbn = isbn;
    }
}
