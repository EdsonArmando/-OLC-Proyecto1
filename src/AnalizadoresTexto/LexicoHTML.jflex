package Analizadores;
import java_cup.runtime.*;
import java.util.ArrayList;
%%
%{
    String cadena="", cadenaInterna = "";
    int c = 0;
%}

%public
%class LexicoHTML
%cupsym Symh
%cup
%char
%line
%column
%full
%unicode
%ignorecase

espacio = \t|\f|" "|\r|\n

%state COMENTMULTI
%state STRING
%state CADENAINTERNA

%%

<STRING>{
    [\"] {  yybegin(YYINITIAL);
            String temporal = cadena; 
            cadena = "";
            return new Symbol(Symh.tCadena, yychar,yyline,temporal);   
         }
    [^\"] { cadena += yytext(); }
}

<COMENTMULTI>{
    "-->"         {yybegin(YYINITIAL);}
    .            {}
    [ \t\r\n\f]  {}
}

<YYINITIAL>{ 
    "<!--"  {yybegin(COMENTMULTI);} 
    "\""    {yybegin(STRING);}
    "html"  {return new Symbol(Symh.tHtml,yycolumn,yyline,yytext());}
    "head"  {return new Symbol(Symh.tHead,yycolumn,yyline,yytext());}
    "body"  {return new Symbol(Symh.tBody,yycolumn,yyline,yytext());}
    "title" {c++; if(c == 2){ c = 0; } return new Symbol(Symh.tTitle,yycolumn,yyline,yytext());}
    "noufe" {c++; if(c == 2){ c = 0; } return new Symbol(Symh.tNoufe,yycolumn,yyline,yytext());}
    "div"   {return new Symbol(Symh.tDiv,yycolumn,yyline,yytext());}
    "body"  {return new Symbol(Symh.tBody,yycolumn,yyline,yytext());}
    "id"    {return new Symbol(Symh.tId,yycolumn,yyline,yytext());}
    "="     {return new Symbol(Symh.tIgual,yycolumn,yyline,yytext());}
    "<"     {return new Symbol(Symh.tMenorQue,yycolumn,yyline,yytext());}
    "/"     {return new Symbol(Symh.tDiagonal,yycolumn,yyline,yytext());}
    ">"     {   
                if(c == 1){
                    yybegin(CADENAINTERNA);
                }
                return new Symbol(Symh.tMayorQue,yycolumn,yyline,yytext());
            }
    {espacio} { /* ignorar */ }
    .       {System.out.println("Error Lexico: <<"+yytext()+">> ["+yyline+" , "+yycolumn+"]");}
}

<CADENAINTERNA>{
    "<" {  yybegin(YYINITIAL);
            String temporal = cadenaInterna; 
            cadena = "";
            yypushback(1);
            return new Symbol(Symh.tCadenaInterna, yychar,yyline,temporal);   
         }
    [^<] { cadenaInterna += yytext(); }
}


