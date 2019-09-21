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
import static Views.Inicio.ent;
import static Views.Inicio.salidaConsola;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author EG
 */
public class ListCombo extends ComponenteJava{
    LinkedList<Atributo> listaAtributos;
    LinkedList<Expresion> exp;
    String po;
    int height, width, x, y,max,min;
    Atributo atrib;
    Simbolo sim;
    Array arrayVE;
    String item;
    ArrayPosicion array;
     public ListCombo(LinkedList<Atributo> listaAtributos,LinkedList<Expresion> elementos){
        this.listaAtributos = listaAtributos;
        this.exp = elementos;
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
                }
        }
        /** Crear nuevo Panel***/
        
        JComboBox nuevo = new JComboBox();
        nuevo.setBounds(this.x, this.y, this.width, this.height);
  
        if(this.exp!=null){
            for(Expresion exp:this.exp){
               array=(ArrayPosicion) exp;
               sim = ent.obtener(array.getId());
               arrayVE = (Array)sim.getValor();
          
            
            item= arrayVE.returnVal(Integer.parseInt(array.getPo()));
            nuevo.addItem(item);
        }
        }
        nuevo.addItem("Hola");
        /** Agregar al entorno Padre **/
        
        obj.add(nuevo);        
        obj.repaint();
        salidaConsola.append("\nEjecutando List");
    }
    
}
