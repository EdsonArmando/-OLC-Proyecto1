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
//import static Views.Inicio.ent;
import static Views.Inicio.salidaConsola;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author EG
 */
public class Label extends ComponenteJava{
     LinkedList<Atributo> listaAtributos;
    int height, width, x, y,tamaño=12;
    Id id;
    boolean subStilo=false,sub=false;
    String letra="Times New Romans",align="",color="";
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
        }
         JLabel nuevo = new JLabel();
        
          System.out.println("Agregando LabelTexto al panel");
         if(subStilo!=false){
              LibreriaColor l = new LibreriaColor();
                System.out.print("\n\n--------"+this.color+"\n\n");
                nuevo.setForeground(l.traducirColor(this.color));
                Font font = new Font(this.letra, Font.BOLD, this.tamaño);
                nuevo.setFont(font);
            if(this.align.equals("left")){
                obj.setLayout(new FlowLayout(FlowLayout.LEFT));
                nuevo.setHorizontalAlignment(JLabel.LEFT);
            }else if(this.align.equals("center")){
                obj.setLayout(new FlowLayout(FlowLayout.CENTER));
                nuevo.setHorizontalAlignment(JLabel.CENTER);
            }else if(this.align.equals("right")){
                 obj.setLayout(new FlowLayout(FlowLayout.RIGHT));
                nuevo.setHorizontalAlignment(JLabel.RIGHT);
            }

             }
        nuevo.setLayout(null);
        
        nuevo.setBounds(this.x, this.y, this.width, this.height);
        if(this.mensaje.getTipo()==Simbolo.EnumTipoDato.ARRAY){
              array=(ArrayPosicion) this.mensaje;
               sim = ent.obtener(array.getId());
               arrayVE = (Array)sim.getValor();
            item= arrayVE.returnVal(Integer.parseInt(array.getPo()),ent);
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
