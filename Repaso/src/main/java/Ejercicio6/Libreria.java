package Ejercicio6;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
public class Libreria {
    private String nombre;
    private String lugar;
    private List<Libro> listaLibros;

    @XmlElementWrapper(name = "ListaLibro")
    @XmlElement(name = "Libro")
    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public Libreria() {
    }

    public Libreria(String nombre, String lugar, List<Libro> listaLibros) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.listaLibros = listaLibros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }


}
