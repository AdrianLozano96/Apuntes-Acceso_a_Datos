package Ejercicio5;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Libreria {
    private String nombre;
    private String lugar;
    private ArrayList<Libro> listaLibro;

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

    @XmlElementWrapper(name="ListaLibro")
    @XmlElement(name="Libro")
    public ArrayList<Libro> getListaLibro() {
        return listaLibro;
    }
    public void setListaLibro(ArrayList<Libro> listaLibro) {
        this.listaLibro = listaLibro;
    }

    public Libreria() {}
    public Libreria(ArrayList<Libro> listaLibro, String nombre, String lugar) {
        super();
        this.listaLibro = listaLibro;
        this.nombre = nombre;
        this.lugar = lugar;
    }
}
