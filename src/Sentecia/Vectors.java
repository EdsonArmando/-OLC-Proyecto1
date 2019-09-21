/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentecia;

import Entorno.Entorno;
import Entorno.Simbolo;
import Entorno.Simbolo.EnumTipoDato;
import Expresion.Expresion;
import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class Vectors extends Sentencia {
    String id;
    LinkedList<Expresion> valores;
    public Vectors(String id, LinkedList<Expresion> valores ){
        this.id = id;
        this.valores = valores;
    }
    @Override
    public void ejecutar(Entorno ent) {
        try{
        ent.insertar(id, new Simbolo(EnumTipoDato.ARRAY, this.valores));
        }catch(Exception e){
         System.out.println(e);
        }
        
    }

    @Override
    public EnumTipoSentencia getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
