/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entorno.Entorno;
import Entorno.Simbolo;
import Expresion.Array;
import Expresion.ArrayPosicion;
import Expresion.Expresion;
import Expresion.Id;
import IntruccionHTML.CSS;
//import static Views.Inicio.ent;
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
    boolean sub=false;
    int height, width, x, y,max,min;
    Atributo atrib;
    Simbolo sim;
    Array arrayVE;
    String item;
    ArrayPosicion array;
    private String letra;
    private String align;
    private String color;
    private int tamaño;
     public ListCombo(LinkedList<Atributo> listaAtributos,LinkedList<Expresion> elementos){
        this.listaAtributos = listaAtributos;
        this.exp = elementos;
        this.x = 0;
        this.y = 0;
    }
    @Override
    public void ejecutar(JPanel obj,Entorno ent) {
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
                }else if(atrib.nombre.equals("classname")){
                    result = atrib.valor;
                   String string=null;
                   String[] parts=null;
                    try{
                     string = result.valor.toString();
                     parts = string.split(" ");
                     System.out.printf(parts[0]);
                     System.out.printf(parts[1]);
                    }catch(Exception e){
                        sub=true;
                    }
                    if(sub==true){
                       for(Atributo atrib:CSS.result){
                         if(atrib.id.equals(result.valor.toString())){
                             for(Atributo atr:atrib.lista){
                                  result = atr.valor;
                            if(atr.nombre.equals("width")){
                                this.width=Integer.parseInt(result.valor.toString());
                            }else if(atr.nombre.equals("height")){
                               
                                this.height = Integer.parseInt(result.valor.toString());
                            }else if(atr.nombre.equals("BorderColor")){
                                Id id;
                                id = (Id) atr.valor;
                                //this.color = id.getId();
                            }else if(atr.nombre.equals("FontColor")){
                                        Id id = (Id)atr.valor;
                                        //this.color = id.getId();
                             }else if(atr.nombre.equals("FontSize")){
                                        result = atr.valor;
                                        //this.tamaño =Integer.parseInt(result.valor.toString());
                                        //this.color = id.getId();
                            }
                           }
                         }
                    
                     } 
                    }else if(sub==false){
                         for(Atributo atrib:CSS.result){
                         if(atrib.id.equals(parts[0])){
                             for(Atributo at:atrib.subLista){
                                 if(at.nombre.equals(parts[1])){
                                     boolean subStilo = true;
                                    for(Atributo subAt:at.lista){
                                    if(subAt.nombre.equals("Font")){
                                        result = subAt.valor;
                                        this.letra=result.valor.toString();
                                    }else if(subAt.nombre.equals("Align")){
                                        Id id = (Id)subAt.valor;
                                        this.align = id.getId();
                                    }else if(subAt.nombre.equals("FontColor")){
                                        Id id = (Id)subAt.valor;
                                        this.color = id.getId();
                                       
                                    }else if(subAt.nombre.equals("FontSize")){
                                        result = subAt.valor;
                                        this.tamaño =Integer.parseInt(result.valor.toString());
                                        //this.color = id.getId();
                                        }
                                    }
                             
                                 }
                             }
                           
                         }
                     }
                    }                  
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
                Expresion items= array.getPosicion();
               item=arrayVE.returnVal(Integer.parseInt(items.valor.toString()),ent);
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
