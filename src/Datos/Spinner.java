/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entorno.Simbolo;
import Expresion.Array;
import Expresion.ArrayPosicion;
import Expresion.Expresion;
import static Views.Inicio.salidaConsola;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author EG
 */
public class Spinner extends ComponenteJava{
    LinkedList<Atributo> listaAtributos;
    Expresion exp;
    String po;
    int height, width, x, y,max,min;
    Atributo atrib;
    Simbolo sim;
    Array arrayVE;
    ArrayPosicion array;
     public Spinner(LinkedList<Atributo> listaAtributos,Expresion exp){
        this.listaAtributos = listaAtributos;
        this.exp = exp;
        this.x = 0;
        this.y = 0;
    }
    @Override
    public void ejecutar(JPanel obj) {
          Expresion result;
         for(int i=0;i<this.listaAtributos.size();i++){
                atrib=this.listaAtributos.get(i);
                if(atrib.nombre.equals("width")){
                    result=atrib.valor;
                    this.width=Integer.parseInt(result.valor.toString());
                }else if(atrib.nombre.equals("height")){
                    result = atrib.valor;
                    this.height = Integer.parseInt(result.valor.toString());
                }else if(atrib.nombre.equals("x")){
                    result = atrib.valor;
                    this.x = Integer.parseInt(result.valor.toString());
                }else if(atrib.nombre.equals("y")){
                    result = atrib.valor;
                    this.y = Integer.parseInt(result.valor.toString());
                }else if(atrib.nombre.equals("max")){
                    result = atrib.valor;
                    this.max = Integer.parseInt(result.valor.toString());
                }else if(atrib.nombre.equals("min")){
                    result = atrib.valor;
                    this.min = Integer.parseInt(result.valor.toString());
                }
        }
        /** Crear nuevo Spinner***/
        SpinnerModel model = new SpinnerNumberModel(Integer.parseInt(this.exp.valor.toString()),this.min,this.max,2);
        JSpinner nuevo = new JSpinner(model);
        nuevo.setBounds(this.x, this.y, this.width, this.height);
  
        nuevo.repaint();
        /** Agregar al entorno Padre **/
        
        obj.add(nuevo);        
        obj.repaint();
        salidaConsola.append("Ejecutando Spinner");
    }
    
}
