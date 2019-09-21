/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentecia;

import Entorno.Entorno;
import Entorno.Simbolo;
import Entorno.Simbolo.EnumTipoDato;
import Expresion.Array;
import Expresion.Expresion;
import static Views.Inicio.salidaConsola;
import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class Declaracion extends Sentencia {
    public LinkedList<Declaracion> declaracion; 
    Simbolo.EnumTipoDato tipoVariable;
    String nombreVariable;
    EnumTipoDato tipoVa=null;
    Expresion expresion;
     public Declaracion(String nombre, Expresion expresion) {
        this.nombreVariable = nombre;
        this.expresion = expresion;
        this.fila = fila;
        this.columna = columna;
    }
     public Declaracion(LinkedList<Declaracion> declaraciones){
         this.declaracion=declaraciones;
     }
    @Override
    public void ejecutar(Entorno ent) {
        Declaracion declaracio;
        Expresion resultado;
        for(int i=0;i<this.declaracion.size();i++){
            declaracio = declaracion.get(i);
            resultado =  declaracio.expresion;
            tipoVa=resultado.getTipo();
        if(tipoVa == EnumTipoDato.ARRAY){
            ent.insertar(declaracio.nombreVariable, new Simbolo(tipoVa, resultado));
        }else if(resultado!=null){
        ent.insertar(declaracio.nombreVariable, new Simbolo(tipoVa, resultado.valor)); // Guardo la variable       
        }else{
        ent.insertar(declaracio.nombreVariable, null);
        }
        }
    }
    @Override
    public EnumTipoSentencia getTipo() {
        return this.tipo;
    }
    
}
