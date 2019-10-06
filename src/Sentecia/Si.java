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
import javax.swing.JPanel;

/**
 *
 * @author EG
 */
public class Si extends Sentencia{
     /**
     * Lista de instrucciones SubIf que serán ejecutadas.
     */
    private final LinkedList<Sentencia> subSis;
    
    /**
     * Constructor utilizado cuando la sentencia solamente tiene un if
     * @param a 
     */
    public Si(SubSi a) {
        subSis=new LinkedList<>();
        subSis.add(a);
    }
    /**
     * Constructor utilizado cuando la sentencia tiene un if seguido de uno o muchos elseif
     * @param a
     * @param b 
     */
    public Si(SubSi a, LinkedList<SubSi> b) {
        subSis=new LinkedList<>();
        subSis.add(a);
        subSis.addAll(b);
    }
    /**
     * Constructor utilizado cuando la sentencia tiene un if seguido de uno o muchos elseif seguido de un else
     * @param a
     * @param b
     * @param c 
     */
    public Si(SubSi a, LinkedList<SubSi> b, SubSi c) {
        subSis=new LinkedList<>();
        subSis.add(a);
        subSis.addAll(b);
        subSis.add(c);
    }
    /**
     * Constructor utilizado cuando la sentencia tiene un if seguido de else
     * @param a
     * @param b 
     */
    public Si(SubSi a, SubSi b) {
        subSis=new LinkedList<>();
        subSis.add(a);
        subSis.add(b);
    }
    /**
     * Método que ejecuta la instrucción si..entonces, es una sobreescritura del 
     * método ejecutar que se debe programar por la implementación de la interfaz
     * instrucción
     * @param ts tabla de símbolos del ámbito padre de la sentencia.
     * @return Estra instrucción retorna nulo porque no produce ningún valor en 
     * su ejecución
     */
    @Override
    public void ejecutar(Entorno ent) {
       //Ejecutar SubIfs
        boolean isTrue=false;
        for(Sentencia in: subSis){
            if(isTrue==false){
                in.ejecutar(ent);
                isTrue=((SubSi)in).getValorCondicion();
            }
            //if(((SubSi)in).getValorCondicion());
            
        }
    }
    public void ejecutar(Entorno ent,JPanel jpanel) {
       //Ejecutar SubIfs
        boolean isTrue=false;
        SubSi sub=null;
        for(Sentencia in: subSis){
            if(isTrue==false){
                if(in instanceof SubSi){
                    sub=(SubSi)in;
                    sub.ejecutar(ent, jpanel);
                }else{
                in.ejecutar(ent);   
                }      
                isTrue=((SubSi)in).getValorCondicion();
            }
            //if(((SubSi)in).getValorCondicion());
            
        }
    }

    @Override
    public EnumTipoSentencia getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
