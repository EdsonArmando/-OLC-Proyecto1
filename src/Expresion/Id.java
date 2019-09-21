/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expresion;

import Entorno.Entorno;
import Entorno.Simbolo;

/**
 *
 * @author EG
 */
public class Id extends Expresion{
     String id;
     
    public Id(String id, int fila, int columna){
        this.id = id;
        this.fila = fila;
        this.columna = columna;
    }
    
    @Override
    public Expresion obtenerValor(Entorno ent) {
        Simbolo sim = ent.obtener(id);
        if(sim!=null){
            // Devolver un objeto con el valor
            return new Literal(sim.getTipo(), sim.getValor());
        }
        // Si la variable NO existe ya se marcó el error y devuelvo una
        // expresión de tipo error para no tener null
        return new Literal(Simbolo.EnumTipoDato.ERROR, "@Error@");
    }
    public String getId(){
        return this.id;
    }
    @Override
    public Simbolo.EnumTipoDato getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
