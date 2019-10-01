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
//import static Views.Inicio.ent;
import static Views.Inicio.salidaConsola;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author EG
 */
public class Imagen extends ComponenteJava {
 LinkedList<Atributo> listaAtributos;
    int height, width, x, y;
    String src;
    Simbolo.EnumTipoDato type;
    Expresion  mensaje;
    Atributo atrib;

     public Imagen(LinkedList<Atributo> listaAtributos){
        this.listaAtributos = listaAtributos;
        this.mensaje = mensaje;
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
                }else if(atrib.nombre.equals("src")){
                    result = atrib.valor;
                    this.src = result.valor.toString();
                }
        }
          System.out.println("Agregando LabelTexto al panel");
        /** Crear nuevo Panel***/
        JLabel nuevo = new JLabel();
        nuevo.setLayout(null);
        nuevo.setIcon(new ImageIcon(this.src));
        nuevo.setBounds(this.x, this.y, this.width, this.height);
        
        nuevo.repaint();
        /** Agregar al entorno Padre **/
        
        obj.add(nuevo);        
        obj.repaint();
        salidaConsola.append("Ejecutando LabelTexto");
    }
    
}
