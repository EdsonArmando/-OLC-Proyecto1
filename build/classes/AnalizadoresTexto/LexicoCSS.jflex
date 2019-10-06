package Analizadores;
import java_cup.runtime.*;
import java.util.ArrayList;
%%
%{
    String cadena="";
    int llamadaString = 0;
    int ESTADOACTUAL = 0;

    public Symbol addSymbol(Symbol s){
        System.out.println(s.value.toString());
        return s;
    }
%}

%public
%class LexicoCSS
%cupsym Symc
%cup
%char
%line
%column
%full
%unicode
%ignorecase

digito = [0-9]
entero = {digito}+
doble = {digito}+"." {digito}+
numero = {digito}+("." {digito}+)?
letra = [a-zA-ZñÑ]
id = {letra}+({letra}|{digito}|"_")*   
caracter = "\'" [^\'] "\'"
espacio = \t|\f|" "|\r|\n


%state COMENTMULTI
%state COMENTSIMPLE
%state STRING

%%

<STRING>{
    [\"] {  yybegin(ESTADOACTUAL);
            String temporal = cadena; 
            cadena = "";
            return addSymbol( new Symbol(Symc.tCadena, yychar,yyline,temporal) );   
         }
    [^\"] { cadena += yytext(); }
}

<COMENTMULTI>{
    "*/"         {yybegin(ESTADOACTUAL);}
    .            {}
    [ \t\r\n\f]  {}
}

<COMENTSIMPLE>{ 
    [^"\n"]      {}
      "\n"       {yybegin(ESTADOACTUAL);}
}

<YYINITIAL>{ 
    "/*"            { ESTADOACTUAL = YYINITIAL; yybegin(COMENTMULTI);} 
    "//"            { ESTADOACTUAL = YYINITIAL; yybegin(COMENTSIMPLE);}
    "\""            { ESTADOACTUAL = YYINITIAL; yybegin(STRING);}
    "{"     {return addSymbol(new Symbol(Symc.tLlaveA,yycolumn,yyline,yytext()));}
    "}"           {return addSymbol(new Symbol(Symc.tLlaveC,yycolumn,yyline,yytext()));}
    "width"      {return addSymbol(new Symbol(Symc.tWidth,yycolumn,yyline,yytext()));}
    "hight"           {return addSymbol(new Symbol(Symc.tHight,yycolumn,yyline,yytext()));}
    "border"       {return addSymbol(new Symbol(Symc.tBorder,yycolumn,yyline,yytext()));}
    "background"     {return addSymbol(new Symbol(Symc.tBackground,yycolumn,yyline,yytext()));}
    "rgb"       {return addSymbol(new Symbol(Symc.tRgb,yycolumn,yyline,yytext()));}
    "align"     {return addSymbol(new Symbol(Symc.tAlign,yycolumn,yyline,yytext()));}
    "size"     {return addSymbol(new Symbol(Symc.tSize,yycolumn,yyline,yytext()));}
    "font"     {return addSymbol(new Symbol(Symc.tFont,yycolumn,yyline,yytext()));}
    "color"     {return addSymbol(new Symbol(Symc.tColor,yycolumn,yyline,yytext()));}    
    ":"        {return addSymbol(new Symbol(Symc.tDosPuntos,yycolumn,yyline,yytext()));}
    "("        {return addSymbol(new Symbol(Symc.tParA,yycolumn,yyline,yytext()));}
    ")"        {return addSymbol(new Symbol(Symc.tParC,yycolumn,yyline,yytext()));}
    ","        {return addSymbol(new Symbol(Symc.tComa,yycolumn,yyline,yytext()));}
    "="             {return addSymbol(new Symbol(Symc.tIgual,yycolumn,yyline,yytext()));}
    "-"             {return addSymbol(new Symbol(Symc.tGuion,yycolumn,yyline,yytext()));}
    ";"             {return addSymbol(new Symbol(Symc.tPuntoComa,yycolumn,yyline,yytext()));}
    "."             {return addSymbol(new Symbol(Symc.tPunto,yycolumn,yyline,yytext()));}
   
    {id}            {return addSymbol(new Symbol(Symc.tId,yycolumn,yyline,yytext()));}
    {caracter}      {return addSymbol(new Symbol(Symc.tCaracter,yycolumn,yyline,yytext()));}
    {entero}        {return addSymbol(new Symbol(Symc.tEntero,yycolumn,yyline,yytext()));}

}

<YYINITIAL>{
    {espacio}       { /* ignorar */ }
    .               {System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");}
}
