/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generadores;

/**
 *
 * @author EG
 */
public class Sintactico {
    public static void main(String[] args)
    {
        int n = 0;
        String  opcionesHTML[] = new String[7], 
                opcionesUFE[] = new String[7], 
                opcionesCSS[] = new String[7];
        
        String destino = "-destdir",
        carpetaTexto = "src/AnalizadoresTexto/",
        carpetaCodigo = "src/Analizadores/",
        simbols = "-symbols",
        simbolsHTML = "Symh",
        simbolsUFE = "Symu",
        simbolsCSS = "Symc",
        par = "-parser",
        sintacticoHTML = "SintacticoHTML",
        sintacticoUFE = "SintacticoUFE",
        sintacticoCSS = "SintacticoCSS";
        
        //Seleccionamos la opción de dirección de destino
        opcionesHTML[n] = opcionesUFE[n] = opcionesCSS[n] = destino;
        
        //Le damos la dirección, carpeta donde se va a generar el parser.java & el simbolosxxx.java        
        n++;
        opcionesHTML[n] = opcionesUFE[n] = opcionesCSS[n] = carpetaCodigo;
        
        //Seleccionamos la opción de nombre de archivo simbolos
        n++;
        opcionesHTML[n] = opcionesUFE[n] = opcionesCSS[n] = simbols;
        
        //Le damos el nombre que queremos que tenga
        n++;
        opcionesHTML[n] = simbolsHTML;
        opcionesUFE[n] = simbolsUFE;
        opcionesCSS[n] = simbolsCSS;
                
        //Seleccionamos la opcion de clase parser
        n++;
        opcionesHTML[n] = opcionesUFE[n] = opcionesCSS[n] = par;
        
        //Le damos nombre a esa clase del paso anterior
        n++;
        opcionesHTML[n] = sintacticoHTML; 
        opcionesUFE[n] = sintacticoUFE;
        opcionesCSS[n] = sintacticoCSS;
        
        //Le decimos donde se encuentra el archivo .cup 
        n++;
        opcionesHTML[n] = carpetaTexto + sintacticoHTML +".cup";
        opcionesUFE[n] = carpetaTexto + sintacticoUFE +".cup";
        opcionesCSS[n] = carpetaTexto + sintacticoCSS +".cup";
        try 
        {
            System.out.println("\n--------------------------------------------------------------------------");
            java_cup.Main.main(opcionesHTML);
            System.out.println("\n--------------------------------------------------------------------------");
            java_cup.Main.main(opcionesCSS);
            System.out.println("\n--------------------------------------------------------------------------");
            java_cup.Main.main(opcionesUFE);
        } 
        catch (Exception ex)
        {
            System.out.print(ex);
        }
    }
}
