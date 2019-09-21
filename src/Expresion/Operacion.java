/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expresion;

import Datos.Atributo.TIPOOPERACION;
import Entorno.Entorno;
import Entorno.Simbolo;

/**
 *
 * @author EG
 */
public class Operacion extends Expresion{
    public Expresion valor1;
    public Expresion valor2;
    public TIPOOPERACION operador;
    public Operacion(Expresion valor1, Expresion valor2, TIPOOPERACION operador){
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.operador = operador;
    }
    @Override
    public Expresion obtenerValor(Entorno ent) {
         Expresion resultadoClave = this.valor1.obtenerValor(ent);
         
         return new Literal(Simbolo.EnumTipoDato.ENTERO, 5);
    }

    @Override
    public Simbolo.EnumTipoDato getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
