/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentecia;

import Entorno.Entorno;
import Entorno.Simbolo;
import Expresion.Expresion;
import Expresion.Literal;
import Expresion.Operacion;

/**
 *
 * @author EG
 */
public class Reasignacion extends Sentencia{
    String nombre;
    Expresion valor;
    public Reasignacion(String nombre, Expresion valor){
        this.nombre = nombre;
        this.valor = valor;
    }
    @Override
    public void ejecutar(Entorno ent) {
        Literal val=(Literal) valor.obtenerValor(ent);
        Simbolo nuevo = new Simbolo(val.getTipo(),val.valor);
            ent.modificarVariable(this.nombre,nuevo);
    }

    @Override
    public EnumTipoSentencia getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
