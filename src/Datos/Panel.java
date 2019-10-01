/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Entorno.Entorno;
import Entorno.Simbolo;
import Expresion.Expresion;
import Expresion.Id;
import IntruccionHTML.CSS;
import IntruccionHTML.LibreriaColor;
import java.awt.Color;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JPanel;
import static Views.Inicio.jPanel1;
import java.awt.Color;
import java.awt.Component;
import java.awt.PopupMenu;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
/**
 *
 * @author EG
 */
public class Panel extends ComponenteJava{
    
    LinkedList<ComponenteJava> listaComponentes;
    LinkedList<Atributo> listaAtributos;
    ComponenteJava java;
    Border borderPanel;
    String color="cyan";
    int height, width, x, y;
    Atributo atrib;
    String colorBorder=null;
    int borderWhit=0;
      public Panel(LinkedList<Atributo> listaAtributos, LinkedList<ComponenteJava> listaComponentes){
        this.listaAtributos = listaAtributos;
        this.listaComponentes = listaComponentes;
        this.x = 0;
        this.y = 0;
    }
     
    @Override
    public void ejecutar(JPanel entorno,Entorno ent) {
        Expresion result;
        Id id;
        LibreriaColor l = new LibreriaColor();
         for(int i=0;i<this.listaAtributos.size();i++){
                atrib=this.listaAtributos.get(i);
                if(atrib.nombre.equals("width")){
                    result=atrib.valor;
                    this.width=Integer.parseInt(result.valor.toString());
                }else if(atrib.nombre.equals("height")){
                    result = atrib.valor;
                    this.height = Integer.parseInt(result.valor.toString());
                }else if(atrib.nombre.equals("color")){
                    result = atrib.valor;
                    this.color = result.valor.toString();
                }else if(atrib.nombre.equals("x")){
                    result = atrib.valor;
                    this.x = Integer.parseInt(result.valor.toString());
                }else if(atrib.nombre.equals("y")){
                    result = atrib.valor;
                    this.y = Integer.parseInt(result.valor.toString());
                }else if(atrib.nombre.equals("classname")){
                    result = atrib.valor;
                    for(Atributo atrib:CSS.result){
                         if(atrib.id.equals(result.valor.toString())){
                             for(Atributo atr:atrib.lista){
                                  result = atr.valor;
                            if(atr.nombre.equals("width")){
                               
                                this.width=Integer.parseInt(result.valor.toString());
                            }else if(atr.nombre.equals("height")){
                               
                                this.height = Integer.parseInt(result.valor.toString());
                            }else if(atr.nombre.equals("BorderWidth")){
                               
                                this.borderWhit = Integer.parseInt(result.valor.toString());
                            }else if(atr.nombre.equals("BorderColor")){
                                id = (Id) atr.valor;
                                this.colorBorder = id.getId();
                            }
                           }
                         }
                    
                     }
                  
                    }
                }
        /** Crear nuevo Panel***/
        JPanel nuevo = new JPanel();
        if(colorBorder != null){
            System.out.println("--------------");
            System.out.println(this.colorBorder);
            borderPanel = BorderFactory.createLineBorder(l.traducirColor(this.colorBorder),this.borderWhit);
            nuevo.setBorder(borderPanel);
        }
       
        nuevo.setLayout(null);
        nuevo.setBounds(this.x, this.y, this.width, this.height);
        
        nuevo.setBackground(l.traducirColor(this.color));
        nuevo.repaint();
        /** Agregar al entorno Padre **/
        
        entorno.add(nuevo);        
        
        
         if(this.listaComponentes!=null){
         for(int i=0;i<this.listaComponentes.size();i++) {
            java = this.listaComponentes.get(i);
            java.ejecutar(nuevo,ent);
        }
         }
         
    }

}
