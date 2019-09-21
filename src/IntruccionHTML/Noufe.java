/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntruccionHTML;

import Expresion.Expresion;

/**
 *
 * @author EG
 */
public class Noufe extends EtiquetaHtml{
    String cadena;
    public Noufe(String cadena){
        this.cadena = cadena;
    }
    
    public String getName(){
        return this.cadena;
    }

    @Override
    public void Ejecutar() {
        
    }
}
