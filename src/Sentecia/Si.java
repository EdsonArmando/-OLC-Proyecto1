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
import static Views.Inicio.salidaConsola;
import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class Si extends Sentencia{
    Expresion condicion1;
    Operacion op;
    Literal valor;
    LinkedList<Sentencia> lista;
    Entorno entSi=new Entorno(null);
    Operacion.Tipo_operacion tipoOperador;
    public Si(Expresion condicion1,LinkedList<Sentencia> lista ){
        this.condicion1 = condicion1;
        this.lista = lista;
    }

    @Override
    public void ejecutar(Entorno ent) {
      entSi.tabla.putAll(ent.tabla);
      op=(Operacion)this.condicion1;
      valor = op.obtenerValor(ent);
      
      if((Boolean) valor.valor==true){
          for(Sentencia sent: this.lista){
              sent.ejecutar(entSi);
          }
      }
    }

    @Override
    public EnumTipoSentencia getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
