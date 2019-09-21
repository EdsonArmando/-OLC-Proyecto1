/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expresion;

import Entorno.Entorno;
import Entorno.Simbolo;
import Entorno.Simbolo.EnumTipoDato;
import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class Array extends Expresion{
    LinkedList<Expresion> datos;
    Simbolo.EnumTipoDato tipo;
    public Array(Simbolo.EnumTipoDato tipo,Object datos){
        this.datos=(LinkedList<Expresion>) datos;
        this.tipo = tipo;
    }   
    @Override
    public Expresion obtenerValor(Entorno ent) {
        return this;
    }
    @Override
    public Simbolo.EnumTipoDato getTipo() {
       return this.tipo;
    }
    public String returnVal(int pos){
        return this.datos.get(pos).valor.toString();
    }
    public LinkedList<Expresion> getArray(){
        return this.datos;
    }
}
