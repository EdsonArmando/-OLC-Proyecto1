/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Entorno.Entorno;
import Entorno.Simbolo;
import Expresion.Expresion;
import IntruccionHTML.LibreriaColor;
import java.awt.Color;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JPanel;
import static Views.Inicio.jPanel1;
import java.awt.Color;
import java.awt.Component;
import java.awt.PopupMenu;
/**
 *
 * @author EG
 */
public class Panel extends ComponenteJava{
    LinkedList<ComponenteJava> listaComponentes;
    LinkedList<Atributo> listaAtributos;
    ComponenteJava java;
    int height, width, x, y;
    Atributo atrib;
    String color;
      public Panel(LinkedList<Atributo> listaAtributos, LinkedList<ComponenteJava> listaComponentes){
        this.listaAtributos = listaAtributos;
        this.listaComponentes = listaComponentes;
        this.x = 0;
        this.y = 0;
    }
     
    @Override
    public void ejecutar(JPanel entorno) {
        Expresion result;
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
                }
        }
        /** Crear nuevo Panel***/
        JPanel nuevo = new JPanel();
        nuevo.setLayout(null);
        nuevo.setBounds(this.x, this.y, this.width, this.height);
        LibreriaColor l = new LibreriaColor();
        nuevo.setBackground(l.traducirColor(this.color));
        nuevo.repaint();
        /** Agregar al entorno Padre **/
        
        entorno.add(nuevo);        
        entorno.repaint();
        
         if(this.listaComponentes!=null){
         for(int i=0;i<this.listaComponentes.size();i++) {
            java = this.listaComponentes.get(i);
            java.ejecutar(nuevo);
        }
         }
         
    }

}
