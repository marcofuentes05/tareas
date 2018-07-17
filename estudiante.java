package main;
public class estudiante {
    private String nombre;
    private int codigo;

    public String getNombre(){
        return nombre;
    }
    public int getCodigo(){
        return codigo;
    }
    public estudiante(String name, int code){
        nombre = name;
        codigo = code;
    }

}
