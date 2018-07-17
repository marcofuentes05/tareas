package main;

import main.estudiante;
import java.util.*;

public class grado {
    private String nombre;
    private List <estudiante> miembros=new ArrayList<estudiante>();

    public String getNombre(){
        return nombre;
    }

    public List<estudiante> getEstudiantes(){
        return miembros;
    }
    public void agregarEstudiante(estudiante e1){
        miembros.add(e1);
    }

        public grado(String nom){
            nombre = nom;
        }

}
