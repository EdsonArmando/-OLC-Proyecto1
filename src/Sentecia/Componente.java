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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author EG
 */
public class Componente extends Sentencia{
    public String id;
    Entorno nuevo=new Entorno(null);
    boolean ejecutado=false;
    public LinkedList<Sentencia> listaAentenciaComponent;
    public Componente(LinkedList<Sentencia> listaSentencia, String id){
        this.listaAentenciaComponent = listaSentencia;
        this.id=id;
    }
    @Override
    public void ejecutar(Entorno ent) {   
        if(ejecutado!=true){
             nuevo.tabla.putAll(ent.tabla);
             ent.insertar(this.id, new Simbolo(EnumTipoDato.COMPONENTE, this.listaAentenciaComponent));
        for(int cont =0;cont<this.listaAentenciaComponent.size(); cont++){
            listaAentenciaComponent.get(cont).ejecutar(this.nuevo);
            }
        }
       
         // Guardo la variable 
    }
 public void ejecutar(Entorno ent,JPanel ento) {
        this.ejecutado=true;
        nuevo.tabla.putAll(ent.tabla);
        ent.insertar(this.id, new Simbolo(EnumTipoDato.COMPONENTE, this.listaAentenciaComponent));
         
        for(int cont =0;cont<this.listaAentenciaComponent.size(); cont++){
            
            if(listaAentenciaComponent.get(cont) instanceof Return){
               
                Return ret = (Return) listaAentenciaComponent.get(cont);
                ret.ejecutar(nuevo, ento);
            }else if(listaAentenciaComponent.get(cont) instanceof Si){
                Si s = (Si) listaAentenciaComponent.get(cont);
                s.ejecutar(nuevo, ento);
            }else{
                listaAentenciaComponent.get(cont).ejecutar(nuevo);
            }
        }
    }
    @Override
    public EnumTipoSentencia getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
