/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entorno;

import java.util.HashMap;
import static Views.Inicio.salidaConsola;
import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class Entorno {
    Entorno anterior;
    public HashMap<String, Simbolo> tabla; //Tabla donde voy a almacenar mis variables
    
     /**
     * Método que crea un nuevo entorno delante del entorno padre.
     * @param anterior El entorno padre.
     */
    public Entorno(Entorno anterior){
        this.tabla = new HashMap<>(); 
        this.anterior = anterior;
    }
    /**
     * Método que agrega una variable al entorno actual.
     * @param nombre El nombre de la nueva variable.
     * @param valor El simbolo con la informacion de esta nueva variable.
     */
    public void insertar(String nombre, Simbolo valor){   
        if (this.tabla.containsKey(nombre)) {
            System.out.println("La variable ya existe");
            return;
        }
        this.tabla.put(nombre, valor);
    }
    
    /**
     * Método que pregunta si la variable esta declarada en el entorno actual.
     * @param nombre El nombre de la variable.
     * @return boolean Si la variable esta declarada=true, si no esta declarada=false.
     */
    public boolean existeVariable(String nombre){
        return this.tabla.containsKey(nombre);
    }
    
    /**
     * Método que devuelve la variable declarada en el entorno actual.
     * @param nombre El nombre de la variable a retornar.
     * @return Simbolo La variable se guarda como un simbolo.
     */
    public Simbolo obtener(String nombre){
        if (tabla.containsKey(nombre)) {
            Simbolo sim = tabla.get(nombre);
            return sim;
        }
        salidaConsola.append("La variable '" + nombre + "' NO existe");
        return null;
    }
    
    public void modificarVariable(String nombre, Simbolo valor){
          if (tabla.containsKey(nombre)) {
            Simbolo sim = tabla.get(nombre);
            tabla.remove(nombre);
            tabla.put(nombre, valor);
        
        }else{
          salidaConsola.append("La variable '" + nombre + "' NO existe");
          }
    }
}
