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
import Expresion.ArrayPosicion;
import Expresion.Expresion;
import Expresion.Id;
import static Views.Inicio.salidaConsola;
import static Views.Inicio.ent;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class Imprimir extends Sentencia{
    LinkedList<Expresion> expresiones;
    Expresion expresion;
    Simbolo sim=null;
    EnumTipoDato type;
    ArrayPosicion arr=null;
    Array arrayVE;
    LinkedList<Expresion>listVal;
    Id id;
    public Imprimir(LinkedList<Expresion> expresiones, int fila, int columna) {
        this.expresiones = expresiones;
        this.fila = fila;
        this.columna = columna;
    }
    @Override
    public void ejecutar(Entorno ent) {
         System.out.println("Ejecutando la instrucción Imprimir");
        String salida = "";
        for (int i = 0; i < this.expresiones.size(); i++) {
         Expresion resultado = this.expresiones.get(i).obtenerValor(ent);
         type = resultado.getTipo();
            if(resultado.getTipo()==EnumTipoDato.ARRAY){
                arr = (ArrayPosicion) resultado;
                sim = ent.obtener(arr.getId());
                arrayVE = (Array)sim.getValor();
                salida+=(arrayVE.returnVal(Integer.parseInt(arr.getPosicion().valor.toString())));
                //listVal = arrayVE.getArray();
                //salida+=listVal.get();
                
            }else
            if(resultado.getTipo() == Simbolo.EnumTipoDato.ERROR){
               ejecutar(Views.Inicio.ent);
            }else{
                salida += resultado.valor.toString();
            }
        }
        System.out.println(salida);
        salidaConsola.append(salida+"\n");
    }

    @Override
    public EnumTipoSentencia getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
