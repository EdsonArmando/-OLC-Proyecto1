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
import Expresion.Id;
import static Views.Inicio.ent;
import static Views.Inicio.salidaConsola;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author EG
 */
public class Label extends ComponenteJava{
     LinkedList<Atributo> listaAtributos;
    int height, width, x, y;
    Id id;
    Simbolo.EnumTipoDato type;
    Expresion  mensaje;
    Atributo atrib;
    Simbolo sim;
    Array arrayVE;
    String item;
    ArrayPosicion array;
        public Label(LinkedList<Atributo> listaAtributos, Expresion mensaje){
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
          System.out.println("Agregando LabelTexto al panel");
        /** Crear nuevo Panel***/
        JLabel nuevo = new JLabel();
        nuevo.setLayout(null);
        nuevo.setBounds(this.x, this.y, this.width, this.height);
        if(this.mensaje.getTipo()==Simbolo.EnumTipoDato.ARRAY){
              array=(ArrayPosicion) this.mensaje;
               sim = ent.obtener(array.getId());
               arrayVE = (Array)sim.getValor();
            item= arrayVE.returnVal(Integer.parseInt(array.getPo()));
            nuevo.setText(item);
        }else{
            nuevo.setText(this.mensaje.valor.toString());
        }
        nuevo.repaint();
        /** Agregar al entorno Padre **/
        
        obj.add(nuevo);        
        obj.repaint();
        salidaConsola.append("Ejecutando LabelTexto");
    }
    
}
