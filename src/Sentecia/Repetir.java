/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentecia;

import Entorno.Entorno;
import Expresion.Expresion;
import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class Repetir extends Sentencia {
    private Expresion operacion;
    private LinkedList<Sentencia> listInstr;
    private Double noVeces;
    public Repetir(Expresion op,LinkedList<Sentencia> listInstr ){
        this.operacion = op;
        this.listInstr = listInstr;
    }
    @Override
    public void ejecutar(Entorno ent) {
         Entorno tablaLocal=new Entorno(null);
         tablaLocal.tabla.putAll(ent.tabla);
         noVeces = (Double)operacion.obtenerValor(tablaLocal).valor;
         while(noVeces!=0){
            for(Sentencia ins:listInstr){
                ins.ejecutar(tablaLocal);
                }
            noVeces--;
         }
        ent.tabla.putAll(tablaLocal.tabla);
    }

    @Override
    public EnumTipoSentencia getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
