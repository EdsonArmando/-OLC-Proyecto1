/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentecia;

import Datos.ComponenteJava;
import Entorno.Entorno;
import Expresion.Expresion;
import Sentecia.Sentencia.EnumTipoSentencia;
//import static Views.Inicio.ent;
import static Views.Inicio.listaInstrucciones;
import static Views.Inicio.salidaConsola;
import static Views.Inicio.salidaConsola;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author EG
 */

public class IdComponente extends ComponenteJava {
    public String id;
    public static boolean ejecutado;
    public IdComponente(String id){
        this.id = id;
    }
    
    @Override
    public void ejecutar(JPanel ent,Entorno ento) {
           System.out.println("HolaIDCOMONENTE");
            EnumTipoSentencia tipo;
            Componente component;
            System.out.print("");
            for (Sentencia i : listaInstrucciones) {
             if(i instanceof Componente){
                 component = (Componente)i;
                 if(component.id.equals(id)){
                  component.ejecutar(ento,ent);
                 ejecutado=true;
                System.out.print(component.id);
            }
         }
     }
    }
}
