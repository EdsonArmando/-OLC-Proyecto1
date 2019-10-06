/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentecia;

import Entorno.Entorno;
import Expresion.Operacion;
import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class Mientras extends Sentencia {
       /**
     * Condición de la sentencia mientras.
     */
    private final Operacion condicion;
    /**
     * Lista de las instrucciones que deben ejecutarse si la condición se cumple.
     */
    private final LinkedList<Sentencia> listaInstrucciones;
    /**
     * Constructor de la clase Mientras
     * @param a condición que debe evaluarse para ejecutar el ciclo
     * @param b instrucciones que deben ejecutarse si la condición se cumpliera
     */
    public Mientras(Operacion a, LinkedList<Sentencia> b) {
        this.condicion=a;
        this.listaInstrucciones=b;
    }
    /**
     * Método que ejecuta la instrucción mientras, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia
     * @return Esta instrucción retorna nulo porque no produce ningun valor
     */
    @Override
    public void ejecutar(Entorno ent) {
        Entorno tablaLocal=new Entorno(null);
        tablaLocal.tabla.putAll(ent.tabla);
         while((Boolean)condicion.obtenerValor(tablaLocal).valor){
            
            for(Sentencia ins:listaInstrucciones){
                ins.ejecutar(tablaLocal);
            }
        }
        ent.tabla.putAll(tablaLocal.tabla);
    }
    @Override
    public EnumTipoSentencia getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
