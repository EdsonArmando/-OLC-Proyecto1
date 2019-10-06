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
import IntruccionHTML.LibreriaColor;
import static Views.Inicio.salidaConsola;
//import static Views.Inicio.ent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
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
    String letra="Times New Romans",align="",color="white";
    int tamaño=8;
    boolean subStilo=false,sub;
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
    public void ejecutar(JPanel obj,Entorno ent) {
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
                                this.color = id.getId();
                            }else if(atr.nombre.equals("FontColor")){
                                        Id id = (Id)atr.valor;
                                        this.color = id.getId();
                             }else if(atr.nombre.equals("FontSize")){
                                        result = atr.valor;
                                        this.tamaño =Integer.parseInt(result.valor.toString());
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
                                     subStilo=true;
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
                 else if(atrib.nombre.equals("onclick")){
                     result = atrib.valor;
                     if(result instanceof ArrayPosicion){
                        array=(ArrayPosicion) result;
                        sim = ent.obtener(array.getId());
                        arrayVE = (Array)sim.getValor();
                        valor=arrayVE.returnVal(Integer.parseInt(array.getPosicion().valor.toString()),ent);
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
         
          System.out.println("Agregando LabelTexto al panel");
         if(subStilo!=false){
             LibreriaColor l = new LibreriaColor();
         nuevo.setBackground(l.traducirColor(this.color));
          Font font = new Font(this.letra, Font.BOLD, this.tamaño);
            nuevo.setFont(font);
            if(this.align.equals("left")){
                obj.setLayout(new FlowLayout(FlowLayout.LEFT));
                nuevo.setHorizontalAlignment(JLabel.LEFT);
            }else if(this.align.equals("center")){
                obj.setLayout(new GridBagLayout());
                obj.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                nuevo.setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
            }else if(this.align.equals("right")){
                 obj.setLayout(new FlowLayout(FlowLayout.RIGHT));
                nuevo.setHorizontalAlignment(JLabel.RIGHT);
            }

             }
         try{
            array=(ArrayPosicion) this.exp;
                sim = ent.obtener(array.getId());
                arrayVE = (Array)sim.getValor();
                Expresion items= array.getPosicion();
               String item=arrayVE.returnVal(Integer.parseInt(items.valor.toString()),ent);
               nuevo.setText(item);
         }catch(Exception e){
              try{
                nuevo.setText(this.exp.valor.toString());
            }catch(Exception es){
                nuevo.setText(this.exp.obtenerValor(ent).valor.toString());
            }
         }
        
        
        nuevo.setLayout(null);
        nuevo.setBounds(this.x, this.y, this.width, this.height);
       
        nuevo.repaint();
        /** Agregar al entorno Padre **/
        
        obj.add(nuevo);        
        obj.repaint();
        salidaConsola.append("Ejecutando Boton");
    }
    
}
