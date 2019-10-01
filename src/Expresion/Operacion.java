/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expresion;

import Datos.Atributo.TIPOOPERACION;
import Entorno.Entorno;
import Entorno.Simbolo;
import static Views.Inicio.salidaConsola;

/**
 *
 * @author EG
 */
public class Operacion extends Expresion{
    
    public static enum Tipo_operacion{
        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        NEGATIVO,
        NUMERO,
        IDENTIFICADOR,
        CADENA,
        MAYOR_QUE,
        MENOR_QUE,
        MAYOR_IGUAL_QUE,
        MENOR_IGUAL_QUE,
        DIFERENTE_QUE,
        IGUAL_QUE,
        NOT,
        AND,
        XOR,
        OR,
        TRUE,
        FALSE,
        POTENCIA,
        CONCATENACION
    }
   
    private final Tipo_operacion tipo;
    
   
    private Expresion operadorIzq;
  
    private Expresion operadorDer;
   
    private Object valor;

    public Operacion(Expresion operadorIzq, Expresion operadorDer, Tipo_operacion tipo) {
        this.tipo = tipo;
        this.operadorIzq = operadorIzq;
        this.operadorDer = operadorDer;
    }

    public Operacion(Expresion operadorIzq, Tipo_operacion tipo) {
        this.tipo = tipo;
        this.operadorIzq = operadorIzq;
    }
 
    public Operacion(String a, Tipo_operacion tipo) {
        this.valor=a;
        this.tipo = tipo;
    }
 
    public Operacion(Expresion a) {
        this.valor=a;
        this.tipo = Tipo_operacion.NUMERO;
    }
  
    @Override
    public Literal obtenerValor(Entorno ent) {
        Expresion a=null;
        Literal numero;
        Expresion b=null;
        try{
            a = (operadorIzq==null)?null:operadorIzq.obtenerValor(ent);
            
        }catch(Exception e){
            numero = (Literal) a;
            a = numero;
            
        }
          try{
            b = (operadorDer==null)?null:operadorDer.obtenerValor(ent);
           
        }catch(Exception e){
            numero = (Literal) a;
            b = numero;
           
        }
        /*Expresion  a = null;
        if(operadorIzq==null){
        }else{
                Id op;
                op = (Id)operadorIzq;
                a=op.obtenerValor(ent);
            }
        Expresion b = null;
        if(operadorDer==null){
        }else{
                Id op;
                op = (Id)operadorDer;
                b=op.obtenerValor(ent);
            }*/
        Object resultado=0.0;
        if(tipo== Tipo_operacion.DIVISION){
            if(a instanceof Literal && b instanceof Literal){
               
                 resultado = Double.valueOf(a.valor.toString())/Double.valueOf(b.valor.toString());
                return new Literal(Simbolo.EnumTipoDato.DOBLE,resultado);
            }else{
                salidaConsola.append("Error de tipos, la división debe hacerse entre números.");
                return null;
            }
        }else if(tipo== Tipo_operacion.MULTIPLICACION){
           
           if(a instanceof Literal && b instanceof Literal){
                resultado = Double.valueOf(a.valor.toString())*Double.valueOf(b.valor.toString());
                return new Literal(Simbolo.EnumTipoDato.DOBLE,resultado);
            }else{
                salidaConsola.append("Error de tipos, la multiplicación debe hacerse entre números.");
                return null;
            }
        }else if(tipo== Tipo_operacion.RESTA){
           
            if(a instanceof Literal && b instanceof Literal){
                 resultado = Double.valueOf(a.valor.toString())-Double.valueOf(b.valor.toString());
                return new Literal(Simbolo.EnumTipoDato.DOBLE,resultado);
            }else{
                salidaConsola.append("Error de tipos, la resta debe hacerse entre números.");
                return null;
            }
        }else if(tipo== Tipo_operacion.POTENCIA){
            if(a instanceof Literal && b instanceof Literal){
                 resultado = Math.pow(Double.valueOf(a.valor.toString()), Double.valueOf(b.valor.toString()));
                return new Literal(Simbolo.EnumTipoDato.DOBLE,resultado);
            }else{
                salidaConsola.append("Error de tipos, la resta debe hacerse entre números.");
                return null;
            }
        }else if(tipo== Tipo_operacion.SUMA){
           
             if(a instanceof Literal && b instanceof Literal){
                 try{
                  resultado = Double.valueOf(a.valor.toString())+Double.valueOf(b.valor.toString());
                 }catch(Exception e){
                     resultado = a.valor.toString()+b.valor.toString();
                 }
               
                return new Literal(Simbolo.EnumTipoDato.DOBLE,resultado);
            }else{
                salidaConsola.append("Error de tipos, la suma debe hacerse entre números.");
                return null;
            }
        }else if(tipo== Tipo_operacion.NEGATIVO){
            if(a instanceof Literal){
              
                resultado = Double.valueOf(a.valor.toString()) * -1;
                return new Literal(Simbolo.EnumTipoDato.DOBLE,resultado);
            }else{
                System.err.println("Error de tipos, el operador negativo debe aplicarse a un número.");
                return null;
            }
        }else if(tipo== Tipo_operacion.NUMERO){
            System.out.println(Double.valueOf(a.valor.toString()));
            return new Literal(Simbolo.EnumTipoDato.ENTERO,resultado);
            
        }else if(tipo== Tipo_operacion.IDENTIFICADOR){
             Simbolo sim = ent.obtener(valor.toString());
            if(sim!=null){
                // Devolver un objeto con el valor
                return new Literal(sim.getTipo(), sim.getValor());
            }
            // Si la variable NO existe ya se marcó el error y devuelvo una
            // expresión de tipo error para no tener null
            return new Literal(Simbolo.EnumTipoDato.ERROR, "@Error@");
        }else if(tipo== Tipo_operacion.CADENA){
            return new Literal(Simbolo.EnumTipoDato.DOBLE,valor);
   
        }else if(tipo== Tipo_operacion.MAYOR_QUE){
            if(a instanceof Literal && b instanceof Literal){
               
                 resultado=(Boolean)((Double.valueOf(a.valor.toString())).doubleValue()>(Double.valueOf(b.valor.toString())).doubleValue());
            
                return new Literal(Simbolo.EnumTipoDato.BOOLEANO,resultado);
            }else{
                System.err.println("Error de tipos, la comparación mayor que debe hacerse entre números.");
                return null;
            }
        }else if(tipo== Tipo_operacion.MENOR_QUE){
            if(a instanceof Literal && b instanceof Literal){
               resultado=(Boolean)((Double.valueOf(a.valor.toString())).doubleValue()<(Double.valueOf(b.valor.toString())).doubleValue());
                return new Literal(Simbolo.EnumTipoDato.BOOLEANO,resultado);
            }else{
                System.err.println("Error de tipos, la comparación menor que debe hacerse entre números.");
                return null;
            }
        }else if(tipo== Tipo_operacion.AND){
            if(a instanceof Literal && b instanceof Literal){
               resultado=Boolean.valueOf(a.valor.toString()) && Boolean.valueOf(b.valor.toString());
                return new Literal(Simbolo.EnumTipoDato.BOOLEANO,resultado);
            }else{
                System.err.println("Error de tipos, la comparación menor que debe hacerse entre números.");
                return null;
            }
        }else if(tipo== Tipo_operacion.OR){
            if(a instanceof Literal && b instanceof Literal){
               resultado=Boolean.valueOf(a.valor.toString()) || Boolean.valueOf(b.valor.toString());
                return new Literal(Simbolo.EnumTipoDato.BOOLEANO,resultado);
            }else{
                System.err.println("Error de tipos, la comparación menor que debe hacerse entre números.");
                return null;
            }
        }else if(tipo== Tipo_operacion.NOT){
            if(a instanceof Literal && b instanceof Literal){
               resultado=Boolean.valueOf(a.valor.toString()) != Boolean.valueOf(b.valor.toString());
                return new Literal(Simbolo.EnumTipoDato.BOOLEANO,resultado);
            }else{
                System.err.println("Error de tipos, la comparación menor que debe hacerse entre números.");
                return null;
            }
        }else if(tipo== Tipo_operacion.XOR){
            if(a instanceof Literal && b instanceof Literal){
               resultado=Boolean.valueOf(a.valor.toString()) ^ Boolean.valueOf(b.valor.toString());
                return new Literal(Simbolo.EnumTipoDato.BOOLEANO,resultado);
            }else{
                System.err.println("Error de tipos, la comparación menor que debe hacerse entre números.");
                return null;
            }
        }else if(tipo== Tipo_operacion.MENOR_IGUAL_QUE){
            if(a instanceof Literal && b instanceof Literal){
                 resultado=(Boolean)((Double.valueOf(a.valor.toString())).doubleValue()<=(Double.valueOf(b.valor.toString())).doubleValue());
                return new Literal(Simbolo.EnumTipoDato.BOOLEANO,resultado);
            }else{
                System.err.println("Error de tipos, la comparación menor o igual que debe hacerse entre números.");
                return null;
            }
        }else if(tipo== Tipo_operacion.MAYOR_IGUAL_QUE){
            if(a instanceof Literal && b instanceof Literal){
                  resultado=(Boolean)((Double.valueOf(a.valor.toString())).doubleValue()>=(Double.valueOf(b.valor.toString())).doubleValue());
                return new Literal(Simbolo.EnumTipoDato.BOOLEANO,resultado);
            }else{
                System.err.println("Error de tipos, la comparación mayor o igual que debe hacerse entre números.");
                return null;
            }
        }else if(tipo== Tipo_operacion.DIFERENTE_QUE){
            if(a instanceof Literal && b instanceof Literal){
                resultado=(Boolean)((Double.valueOf(a.valor.toString())).doubleValue()!=(Double.valueOf(b.valor.toString())).doubleValue());
                return new Literal(Simbolo.EnumTipoDato.BOOLEANO,resultado);
            }else{
                System.err.println("Error de tipos, la comparación diferente que debe hacerse entre números.");
                return null;
            }
        }else if(tipo== Tipo_operacion.IGUAL_QUE){
            if(a instanceof Literal && b instanceof Literal){
                resultado=(Boolean)((Double.valueOf(a.valor.toString())).doubleValue()==(Double.valueOf(b.valor.toString())).doubleValue());
                return new Literal(Simbolo.EnumTipoDato.BOOLEANO,resultado);
            }else{
                System.err.println("Error de tipos, la comparación igual que debe hacerse entre números.");
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public Simbolo.EnumTipoDato getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
