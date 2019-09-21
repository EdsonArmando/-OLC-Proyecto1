/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntruccionHTML;

import Analizadores.LexicoCSS;
import Analizadores.SintacticoCSS;
import Expresion.Expresion;
import Views.Inicio;
import static Views.Inicio.salidaConsola;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/**
 *
 * @author EG
 */
public class Div extends EtiquetaHtml{
    String id;
    public Div(String id){
        this.id = id;
    }
    @Override
    public void Ejecutar() {
       
        //sintactico.salidaConsola = salidaConsola
    }
    
}
