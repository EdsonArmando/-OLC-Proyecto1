/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entorno;

/**
 *
 * @author EG
 */
public class Simbolo {
    private final EnumTipoDato tipo;
    private Object valor;    
    
     /**
     * Enumeración que lista todos los tipos de variable reconocidos en el lenguaje.
     */
    public static enum EnumTipoDato{
        CARACTER,
        CADENA,
        ENTERO,
        DOBLE,
        ERROR,
        BOOLEANO,
        ARRAY,
        COMPONENTE,
    }
    public static enum TipoOperador{
        IGUAL,
        MAYOR,
        MENOR,
        MAYORQUE,
        MENORQUE,
    }
    /**
     * Constructor de la clase Símbolo.
     * @param tipo tipo de la variable que se desea almacenar
     * @param valor el valor para el simbolo que se va a guardar
     */
    public Simbolo(EnumTipoDato tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    /**
     * Método que devuelve el valor que almacena la variable.
     * @return Valor de la variable
     */
    public Object getValor() {
        return this.valor;
    }
    /**
     * Método que asigna un nuevo valor a la variable.
     * @param valor Nuevo valor para la variable.
     */
    void setValor(Object valor) {
        this.valor=valor;
    }
    
    /**
     * Método que retorna el tipo de la variable.
     * @return EnumTipo la enumeracion del tipo de variable.
     */
    public EnumTipoDato getTipo(){
        return this.tipo;
    }
}
