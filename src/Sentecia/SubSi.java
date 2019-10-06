/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentecia;

import Entorno.Entorno;
import Expresion.Literal;
import Expresion.Operacion;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author EG
 */
public class SubSi extends Sentencia {
    private Boolean valorCondicion=false;
    private Boolean SiEjecutado=false;
    private final boolean isElse;
    
    private final Operacion condicion;
   
    private final LinkedList<Sentencia> listaInstrucciones;
  
    public SubSi(Operacion a, LinkedList<Sentencia> b) {
        condicion=a;
        listaInstrucciones=b;
        isElse=false;
    }
   
    public SubSi(LinkedList<Sentencia> a) {
        condicion=null;
        listaInstrucciones=a;
        isElse=true;
    }
    /**
     * Método get utilizado para determinar si más sentencias SubIf deben 
     * ejecutarse o no en la sentencia If padre
     * @param a 
     */
    public Boolean getValorCondicion() {
        return valorCondicion || isElse;
    }
    @Override
    public void ejecutar(Entorno ent) {
        Literal valor=null;
        Return returns=null;
        if(this.condicion!=null){
             valor= condicion.obtenerValor(ent);
             valorCondicion= (Boolean) valor.valor;
        }
        if(valorCondicion==true){
            SiEjecutado=true;
             Entorno tablaLocal=new Entorno(null);
            tablaLocal.tabla.putAll(ent.tabla);
            for(Sentencia in: listaInstrucciones){
                in.ejecutar(tablaLocal);
            }
            ent.tabla.putAll(tablaLocal.tabla);
        }else if(isElse==true && SiEjecutado==false){
            Entorno tablaLocal=new Entorno(null);
            tablaLocal.tabla.putAll(ent.tabla);
            for(Sentencia in: listaInstrucciones){
                in.ejecutar(tablaLocal);
            }
            ent.tabla.putAll(tablaLocal.tabla);
        }
    }
    
    public void ejecutar(Entorno ent,JPanel padre) {
        Literal valor=null;
        Return returns=null;
        if(this.condicion!=null){
             valor= condicion.obtenerValor(ent);
             valorCondicion= (Boolean) valor.valor;
        }
        if(valorCondicion==true){
            SiEjecutado=true;
             Entorno tablaLocal=new Entorno(null);
            tablaLocal.tabla.putAll(ent.tabla);
            for(Sentencia in: listaInstrucciones){
                 if(in instanceof Return){
                    returns = (Return) in;
                    returns.ejecutar(tablaLocal, padre);
                }else{
                      in.ejecutar(tablaLocal);
                 }
            }
            ent.tabla.putAll(tablaLocal.tabla);
        }else if(isElse==true && SiEjecutado==false){
            Entorno tablaLocal=new Entorno(null);
            tablaLocal.tabla.putAll(ent.tabla);
           for(Sentencia in: listaInstrucciones){
                 if(in instanceof Return){
                    returns = (Return) in;
                    returns.ejecutar(tablaLocal, padre);
                }else{
                      in.ejecutar(tablaLocal);
                 }
            }
            ent.tabla.putAll(tablaLocal.tabla);
        }
    }

    @Override
    public EnumTipoSentencia getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
