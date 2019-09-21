/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Expresion.Expresion;
import static Views.Inicio.salidaConsola;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author EG
 */
public class TextField extends ComponenteJava{
     LinkedList<Atributo> listaAtributos;
    int height, width, x, y;
    LinkedList<Expresion> mensaje;
    Atributo atrib;
    String palabras="";
     public TextField(LinkedList<Atributo> listaAtributos,LinkedList<Expresion> mensaje ){
        this.listaAtributos = listaAtributos;
        this.mensaje = mensaje;
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
        JTextField nuevo = new JTextField();
        nuevo.setLayout(null);
        nuevo.setBounds(this.x, this.y, this.width, this.height);

       if(this.mensaje!=null){
           for(Expresion exp:this.mensaje){
               palabras+=exp.valor.toString();
           }    
        }
        
        nuevo.setText(palabras);
        nuevo.repaint();
        /** Agregar al entorno Padre **/
        
        obj.add(nuevo);        
        obj.repaint();
        salidaConsola.append("\nEjecutando TextField");
    }
}
