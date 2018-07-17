package main;
import main.grado;

import java.util.*;

public class nivel {
    private String nombre;
    private List <grado> grados=new ArrayList<grado>();
    private int numGrados;

    public String getNombre(){
        return nombre;
    }
    public List<grado> getGrados(){
        return grados;
    }

    public void agregarGrado(grado gra){
        grados.add(gra);
    }
    public nivel(String nom){
        nombre = nom;

    }
}
