/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expresion;

import Entorno.Entorno;
import Entorno.Simbolo;
import Entorno.Simbolo.EnumTipoDato;

/**
 *
 * @author EG
 */
public class ArrayPosicion extends Expresion {
    String id;
    Expresion posicion;
    EnumTipoDato tipo;
    String po;
    public ArrayPosicion(String id, Expresion exp, Simbolo.EnumTipoDato tipo){
        this.id = id;
        this.posicion = exp;
        this.tipo = tipo;
    }
     public ArrayPosicion(String id, String exp, Simbolo.EnumTipoDato tipo){
        this.id = id;
        this.po = exp;
        this.tipo = tipo;
    }
    @Override
    public Expresion obtenerValor(Entorno ent) {
        return this;
    }
    public String getId(){
        return this.id;
    };
    public Expresion getPosicion(){
        return this.posicion;
    };
    public String getPo(){
        return this.po;
    };
    @Override
    public Simbolo.EnumTipoDato getTipo() {
       return this.tipo;
    }
    
}
