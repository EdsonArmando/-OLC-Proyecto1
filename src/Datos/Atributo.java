/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Expresion.Expresion;
import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class Atributo {
    String nombre;
    Expresion valor;
    String id;
    LinkedList<Atributo> subLista;
    LinkedList<Atributo> lista;
    public Atributo(String nombre, Expresion valor){
        this.nombre = nombre;
        this.valor = valor;
    }
    public Atributo(String id,LinkedList<Atributo> lista){
        this.id = id;
        this.lista = lista;
    }
      public enum TIPOOPERACION{
        MULTIPLICACION,
        SUMA,
        DIVISION,
        RESTA
    }
}
