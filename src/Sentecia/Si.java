/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentecia;

import Entorno.Entorno;
import Entorno.Simbolo;
import Expresion.Expresion;
import static Views.Inicio.salidaConsola;
import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class Si extends Sentencia{
    Expresion condicion1;
    Expresion condicion2;
    LinkedList<Sentencia> lista;
    Simbolo.TipoOperador tipoOperador;
    public Si(Expresion condicion1,Expresion condicion2,Simbolo.TipoOperador operador, LinkedList<Sentencia> lista ){
        this.condicion1 = condicion1;
        this.condicion2 = condicion2;
        this.tipoOperador = operador;
        this.lista = lista;
    }

    @Override
    public void ejecutar(Entorno ent) {
      salidaConsola.append("\nEjecutandoSentenciaSi"+this.tipoOperador.toString()+"\n");
    }

    @Override
    public EnumTipoSentencia getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
