/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntruccionHTML;

import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class Head extends InstruccionHtml{
    LinkedList<EtiquetaHtml> lista;
    public Head(LinkedList<EtiquetaHtml> lista){
        this.lista = lista;
    }
    @Override
    public void Ejecutar() {
        for(EtiquetaHtml eti: lista){
            eti.Ejecutar();
        }
    }
    
}
