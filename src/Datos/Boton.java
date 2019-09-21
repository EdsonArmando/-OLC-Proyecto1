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
import IntruccionHTML.LibreriaColor;
import static Views.Inicio.salidaConsola;
import static Views.Inicio.ent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author EG
 */
public class Boton extends ComponenteJava{
    LinkedList<Atributo> listaAtributos;
    Expresion exp;
    String po;
    int height, width, x, y;
    Atributo atrib;
    Simbolo sim;
    Array arrayVE;
    ArrayPosicion array;
    String valor="";
     public Boton(LinkedList<Atributo> listaAtributos,Expresion exp){
        this.listaAtributos = listaAtributos;
        this.exp = exp;
        this.x = 0;
        this.y = 0;
    }
    @Override
    public void ejecutar(JPanel obj) {
        JButton nuevo = new JButton();
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
                 else if(atrib.nombre.equals("onclick")){
                     result = atrib.valor;
                     if(result instanceof ArrayPosicion){
                        array=(ArrayPosicion) result;
                        sim = ent.obtener(array.getId());
                        arrayVE = (Array)sim.getValor();
                        valor=arrayVE.returnVal(Integer.parseInt(array.getPosicion().valor.toString()));
                     }else{
                        result=result.obtenerValor(ent);
                        valor=result.valor.toString();
                        
                     }
                        
                      nuevo.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showConfirmDialog(null,valor);
                        //salidaConsola.append(arrayVE.returnVal(Integer.parseInt(array.getPosicion().valor.toString())));
                    }
                });
                  
                }
        }
      
        array=(ArrayPosicion) this.exp;
        sim = ent.obtener(array.getId());
        arrayVE = (Array)sim.getValor();
        System.out.println("Agregando Boton al panel");
        /** Crear nuevo Panel***/
        
        nuevo.setText(arrayVE.returnVal(Integer.parseInt(array.getPo())));
        nuevo.setLayout(null);
        nuevo.setBounds(this.x, this.y, this.width, this.height);
       
        nuevo.repaint();
        /** Agregar al entorno Padre **/
        
        obj.add(nuevo);        
        obj.repaint();
        salidaConsola.append("Ejecutando Boton");
    }
    
}
