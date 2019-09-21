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
%state UFEX

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
    {id}         {return addSymbol(new Symbol(Symc.tId,yycolumn,yyline,yytext()));}
    "{"          {return new Symbol(Symc.tLlaveA,yycolumn,yyline,yytext());}
    "border"     {return new Symbol(Symc.tBorder,yycolumn,yyline,yytext());}
    "color"      {return new Symbol(Symc.tColor,yycolumn,yyline,yytext());}
    "-"          {return new Symbol(Symc.tGuion,yycolumn,yyline,yytext());}
    ":"          {return new Symbol(Symc.tDosPuntos,yycolumn,yyline,yytext());}
    "width"      {return new Symbol(Symc.tWidth,yycolumn,yyline,yytext());}
    "hight"      {return new Symbol(Symc.tHight,yycolumn,yyline,yytext());}
    "font"       {return new Symbol(Symc.tFont,yycolumn,yyline,yytext());}
    "align"      {return new Symbol(Symc.tFont,yycolumn,yyline,yytext());}
    "left"       {return new Symbol(Symc.tLeft,yycolumn,yyline,yytext());}
    "right"      {return new Symbol(Symc.tRight,yycolumn,yyline,yytext());}
    "center"     {return new Symbol(Symc.tCenter,yycolumn,yyline,yytext());}
    "border"     {return new Symbol(Symc.tBorder,yycolumn,yyline,yytext());}
    "background" {return new Symbol(Symc.tBack,yycolumn,yyline,yytext());}
    "rgb"        {return new Symbol(Symc.tRGB,yycolumn,yyline,yytext());}
    "#"          {return new Symbol(Symc.tNumeral,yycolumn,yyline,yytext());}
    ";"          {return new Symbol(Symc.tPuntoComa,yycolumn,yyline,yytext());}
    "}"          {return new Symbol(Symc.tLlaveC,yycolumn,yyline,yytext());}
    {entero}     {return addSymbol(new Symbol(Symc.tEntero,yycolumn,yyline,yytext()));}
}
<YYINITIAL, UFEX>{
    {espacio}       { /* ignorar */ }
    .               {System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");}
}
