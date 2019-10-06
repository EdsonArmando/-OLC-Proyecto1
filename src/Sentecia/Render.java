/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentecia;

import Entorno.Entorno;
import Expresion.Expresion;
import static Views.Inicio.salidaConsola;

/**
 *
 * @author EG
 */
public class Render extends Sentencia{
    public String idComponente;
    public String idComponenteHtml;
    public Render(String id, String idCompoHtml){
        this.idComponente =id;
        this.idComponenteHtml = idCompoHtml;
    }
    @Override
    public void ejecutar(Entorno ent) {
        salidaConsola.append("Ejecutando renderizado"+idComponente+"\n");
    }

    @Override
    public EnumTipoSentencia getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
