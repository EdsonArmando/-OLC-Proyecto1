/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntruccionHTML;

import Analizadores.LexicoCSS;
import Analizadores.LexicoUFE;
import Analizadores.SintacticoCSS;
import Analizadores.SintacticoUFE;
import Datos.Atributo;
import Entorno.Entorno;
import Entorno.Simbolo;
import Expresion.Expresion;
import Expresion.Literal;
import Sentecia.Sentencia;
import static Views.Inicio.salidaConsola;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;

/**
 *
 * @author EG
 */
public class CSS extends Sentencia {
    public static LinkedList<Atributo> result;
    String aux = "";
    String texto = "";
    Expresion ruta;
    public CSS(Expresion ruta){
        this.ruta = ruta;
    }

    @Override
    public void ejecutar(Entorno ent) {
      Expresion resultadoNombreArchivo = this.ruta.obtenerValor(ent);
         File abre= new File(String.valueOf(resultadoNombreArchivo.valor));
         FileReader archivos = null;
        try {
                archivos = new FileReader(abre);
        } catch (FileNotFoundException e3) {
                e3.printStackTrace();
        }
        BufferedReader lee=new BufferedReader(archivos);
         try {
                while((aux=lee.readLine())!=null)
                  {
                     texto+= aux+ "\n";
                  }
        } catch (IOException e2) {
                e2.printStackTrace();
        }
         try {
                        lee.close();
                } catch (IOException e1) {
                        e1.printStackTrace();
                }
         LexicoCSS lexico = new LexicoCSS(new BufferedReader(new StringReader(texto)));
         System.out.println("Hola");
         
        SintacticoCSS sintactico = new SintacticoCSS(lexico);
        //sintactico.salidaConsola = salidaConsola;
        
        try{
            sintactico.parse();
        result=sintactico.resultado;
        }catch(Exception e){
            System.out.println(e);
        }
        /*a_Lexico_datos lexico = new a_Lexico_datos(new BufferedReader(new StringReader(texto)));
        analisis_sintacticos_datos sintactico = new analisis_sintacticos_datos(lexico);
        try{
            sintactico.parse();
            Archivo arbol = sintactico.resultado;
         
            return new Literal(Simbolo.EnumTipoDato.ARCHIVO, arbol);
        }catch(Exception e){
            System.out.println(e);
        }*/
    }

    @Override
    public EnumTipoSentencia getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
