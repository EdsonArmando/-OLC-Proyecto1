/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentecia;

import Datos.ComponenteJava;
import Entorno.Entorno;
import static Views.Inicio.salidaConsola;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author EG
 */
public class Return extends Sentencia{
    public LinkedList<ComponenteJava> listaComponentes;
    String id="";
    public Return(LinkedList<ComponenteJava> listaComponentes){
        this.listaComponentes = listaComponentes;
    }
    public Return(String id){
        this.id = id;
    }
    @Override
    public void ejecutar(Entorno ent) {
        salidaConsola.append("Ejecutando la instruccion 1");
        if(this.listaComponentes !=null){
            for(int i=0;i<this.listaComponentes.size();i++){
            this.listaComponentes.get(i).ejecutar(Views.Inicio.jPanel1,ent);
            }
        }else{
        salidaConsola.append(id);
        }   
    }
    public void ejecutar(Entorno ent,JPanel padre) {
        
        if(id.equals("")){
        salidaConsola.append("Ejecutando la instruccion 2");
        if(this.listaComponentes !=null){
             for(int i=0;i<this.listaComponentes.size();i++){
            this.listaComponentes.get(i).ejecutar(padre,ent);
            }
        }   
        }
    }
    @Override
    public EnumTipoSentencia getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
