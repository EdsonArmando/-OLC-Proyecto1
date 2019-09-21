/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expresion;

import Entorno.Entorno;
import Entorno.Simbolo.EnumTipoDato;

/**
 *
 * @author EG
 */
public abstract class Expresion {
     public int fila, columna;
    public Object valor;
    public EnumTipoDato tipo;
    public abstract Expresion obtenerValor(Entorno ent);
    public abstract EnumTipoDato getTipo();
}
