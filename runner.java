package main;

import com.sun.org.apache.xpath.internal.SourceTree;
import main.*;

import java.io.IOException;
import java.util.*;


public class runner {
    public static void main(String [] args){
        List <nivel> niveles = new ArrayList<nivel>();

        //Agregamos algunos niveles, grados y alumnos para pruebas
        nivel primaria = new nivel("primaria");
        nivel basicos = new nivel("basicos");
        nivel diversificado = new nivel("diversificado");
        niveles.add(primaria);
        niveles.add(basicos);
        niveles.add(diversificado);

        grado primeroP = new grado("Primero Primaria");
        grado primeroB = new grado ("Primero Basico");
        grado cuartoB = new grado ("Cuarto Bachillerato");

        primaria.agregarGrado(primeroP);
        basicos.agregarGrado(primeroB);
        diversificado.agregarGrado(cuartoB);

        estudiante e1 = new estudiante("Marco Fuentes",18188);
        estudiante e2 = new estudiante ("Gustavo Fuentes", 15055);
        estudiante e3 = new estudiante("Janina Lima", 98985);

        primeroP.agregarEstudiante(e1);
        primeroB.agregarEstudiante(e2);
        cuartoB.agregarEstudiante(e3);

        int respuesta = 0;
        do {
            System.out.println("Escoja una de las siguientes opciones al ingresar el numero correspondiente...");
            System.out.println("1. Agregar nivel");
            System.out.println("2. Agregar grado");
            System.out.println("3. Agregar Estudiante");
            System.out.println("4. Ver grados en un nivel");
            System.out.println("5. Ver asignaciones en un grado");
            System.out.println("6. Salir");


            Scanner input = new Scanner(System.in);
            if (input.equals("1") || input.equals("2")||input.equals("3")||input.equals("4")||input.equals("5")||input.equals("6")){
                respuesta = input.nextInt();
                if (respuesta ==1){
                    System.out.println("Ingrese el nombre del Nivel");
                    Scanner in = new Scanner(System.in);
                    String nombre = in.toString();
                    niveles.add(new nivel(nombre));
                }else if (respuesta == 2){
                    System.out.println("Ingresa el nombre del nivel");
                    Scanner in = new Scanner (System.in);
                    String niv = in.toString();
                    System.out.println("Ingresa el nombre del grado");
                    Scanner gra = new Scanner (System.in);
                    String grado =  gra.toString();
                    int i = 0;
                    for(nivel p:niveles){
                        if (p.getNombre().equals(niv)){
                            p.agregarGrado(new grado(grado));
                            i = 1;
                        }
                    }
                    if (i==0){
                        System.out.println("El nivel no existe. Verifica y prueba de nuevo");
                    }
                }else if (respuesta == 3){
                    System.out.println("Ingrese el nombre del nivel");
                    String nombreNivel = new Scanner (System.in).toString();
                    System.out.println("Ingrese el nombre del grado");
                    String nombreGrado = new Scanner(System.in).toString();
                    System.out.println("Ingrese el nombre del estudiante");
                    String nombreEstudiante = new Scanner(System.in).toString();
                    System.out.println("Ingrese el codigo del estudiante");
                    int codigoEstudiante = new Scanner (System.in).nextInt();
                    int control = 0;
                    for (nivel q:niveles) {
                        if (q.getNombre().equals(nombreNivel)) {
                            for (grado a : q.getGrados()) {
                                if (a.getNombre().equals(nombreGrado)) {
                                    a.agregarEstudiante(new estudiante(nombreEstudiante, codigoEstudiante));
                                    control = 1;
                                }
                            }
                        }
                    }
                    if (control == 0){
                        System.out.println("Los datos ingresados de grado o nivel no existen. Verifica y prueba de nuevo");
                    }

                }else if (respuesta == 4){
                    System.out.println("Ingrese el nombre del Nivel");
                    String nom = new Scanner (System.in).toString();
                    int y = 0;
                    for (nivel n : niveles){
                        if (n.getNombre().equals(nom)){
                            System.out.println("Nivel: "+ nom);
                            for (grado g:n.getGrados()){
                                System.out.println("'"+g.getNombre()+"'");
                                y=1;
                            }
                        }
                    }
                    if (y == 0){
                        System.out.println(("El nivel no existe. Verifica y preuba de nuevo"));
                    }
                }else if (respuesta == 5){
                    System.out.println("Ingrese el nombre del nivel");
                    String nivel = new Scanner (System.in).toString();
                    System.out.println("Ingrese el nombre del grado");
                    String grado = new Scanner (System.in).toString();

                    for (nivel a : niveles){
                        if (a.getNombre().equals(nivel)){
                            for (grado b:a.getGrados()){
                                if (b.getNombre().equals(grado)){
                                    System.out.println("Nivel: "+nivel);
                                    System.out.println("Grado: "+grado);
                                    for (estudiante c :b.getEstudiantes()){
                                        System.out.println("Codigo: "+c.getCodigo()+"\t Nombre: "+c.getNombre());
                                    }
                                }
                            }
                        }
                    }
                }else{
                    System.out.println("Hasta luego!");
                }
            }else{
                System.out.println("Ese no es un dato válido, intenta de nuevo...");
            }
        }while(respuesta != 5);
    }
}
