/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentecia;

import Entorno.Entorno;

/**
 *
 * @author EG
 */
public abstract class Sentencia {
    int fila, columna;
    public EnumTipoSentencia tipo;
    public abstract void ejecutar(Entorno ent);
    public abstract EnumTipoSentencia getTipo();
    
    public enum EnumTipoSentencia{
       DECLARACION,
       IMPRIMIR,
       REASIGNACION,
       COMPONENTE,
       LEERARCHIVO,
       GRAFICAR
    }           
}
