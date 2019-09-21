/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Generadores;
import java.util.logging.Level;
import java.util.logging.Logger;
import jflex.SilentExit;
/**
 *
 * @author EG
 */
public class Lexico {
      public static void main(String[] args) 
    {
        String  pathDestino = "src/Analizadores/";
        System.out.println("\n--------------------------------------------------------------------------");
        generarLexer(pathDestino, "src/AnalizadoresTexto/LexicoHTML.jflex");
        System.out.println("\n--------------------------------------------------------------------------");
        generarLexer(pathDestino, "src/AnalizadoresTexto/LexicoCSS.jflex");
        System.out.println("\n--------------------------------------------------------------------------");
        generarLexer(pathDestino, "src/AnalizadoresTexto/LexicoUFE.jflex");
    } 
      public static void generarLexer(String pathDestino, String archivoOrigenTexto)
    {
        int n = 0;
        String  argumentos[] = new String[3];
        argumentos[n] = "-d"; n++;
        argumentos[n] = pathDestino; n++;
        argumentos[n] = archivoOrigenTexto;
        
        try {
            jflex.Main.generate(argumentos);
        } catch (SilentExit ex) {
            Logger.getLogger(Lexico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
